package otherIO2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * �ļ��ָ�
 * 
 * @author yinyiliang
 *
 */

public class SplitFileSequence {

	private String filePath;//�ļ�·��
	
	private String fileName;//�ļ���
	
	private long filelength;//�ļ���С
	
	private int num;//����
	
	private long blockSize;//ÿ���С
	
	private String destBlockPath;//�ָ��Ĵ��Ŀ¼
	
	private List<String> blockPath;//���ڴ��ÿ���·�����б�
	
	public SplitFileSequence() {
		blockPath = new ArrayList<String>();
	}

	public SplitFileSequence(String filePath,String destBlockPath) {
		
		this(filePath,destBlockPath,1024);
	}
	
	public SplitFileSequence(String filePath,String destBlockPath,long blockSize) {
		this();
		this.filePath = filePath;
		this.blockSize = blockSize;
		this.destBlockPath = destBlockPath;
		init();
	}
	
	
	
	
	/**
	 * ��ʼ������ ������� 
	 */
	public void init(){
		
		File src = null;
		
		//��׳��
		if( null==filePath || !( ( src=new File(filePath) ).exists() ) || src.isDirectory() ){
			return;//��������
		}
		
		this.fileName = src.getName();
		
		//������� ʵ�ʴ�С��ÿ���С
		this.filelength = src.length();
		//����ÿ���С
		if(this.blockSize>filelength){
			this.blockSize = filelength;
		}
		
		//ȷ������
		num = (int) Math.ceil(filelength*1.0/this.blockSize);//Math.ceil()���ش��ڻ���ں���������������֮��ӽ�������
		
		initPathName();//ȷ��ÿһ��Ĵ��·��
		
	}
	
	private void initPathName(){
		
		for(int i=0; i<num; i++){
			this.blockPath.add(destBlockPath + "/"+ this.fileName+"-part"+i+".txt");
		}
	}
	
	
	/**
	 * �ļ��ָ�
	 * 
	 * �ڼ���
	 * ��ʼλ��
	 * ʵ�ʴ�С
	 * 
	 * @param destPath �ָ��ļ����Ŀ¼
	 */
	public void split(){
		
	
		long beginPos = 0; //��ʼ��
		long actualBlockSize = blockSize; //ʵ�ʴ�С
		
		
		//����ÿһ��Ŀ�ʼλ��(�������α�)
		for(int i=0;i<num;i++){
			
			if(i==num-1){//���һ���ʵ�ʴ�С������ǹ涨�ָ��ÿ���С��ͬ,�������ܳ��ȼ�ȥ��ʵλ�þ͵�ʵ�ʴ�С
				actualBlockSize = this.filelength-beginPos;
			}
			
			splitDetail(i, beginPos,actualBlockSize);
			beginPos += actualBlockSize;//���ε��յ������һ�ε����
		}
	}
	
	
	/**
	 * �ļ��ָ�  ���� ���
	 * 
	 * �ļ�����
	 * @param index
	 * @param beginPos
	 * @param actualBlockSize
	 */
	private void splitDetail(int index, long beginPos, long actualBlockSize){
		
		//����Դ
		File src = new File(this.filePath); //Դ�ļ�
		File dest = new File(this.blockPath.get(index));//Ŀ���ļ�
		
		//ѡ����
		RandomAccessFile raf = null; //������
		BufferedOutputStream bos = null; //�����
		
		try {
			raf = new RandomAccessFile(src,"r");//ֻ�� �������
			bos = new BufferedOutputStream(new FileOutputStream(dest));
			
			//��ȡ�ļ�
			raf.seek(beginPos);
			//������
			byte[] flush  = new byte[1024];
			int len =0;
			while(-1!= (len=raf.read(flush))){
				
				if(actualBlockSize-len>0){
					//д��
					bos.write(flush,0,len);//ֻд��һ���ǲ��Եģ�ÿ�ζ�дlen���������actualBlockSize�������ƵĻ���һֱ����ĩβ����ÿ���ָ��ļ�����Դ�ļ�����ĩβ
					actualBlockSize-=len;//дһ�� �ͼ���һ�� �õ�ʣ����
					
				} else {
					//�����һ�� ֱ��д��ʣ��������
					bos.write(flush,0,(int)actualBlockSize);
					break;//ֹͣѭ��
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			FileCloseUtil.close(bos,raf);
		}
	}
	
	
	/**
	 * �ļ��ĺϲ�
	 * 
	 * @param args
	 */
	public void merge(String destPath){
		
		//����Դ
		File dest = new File(destPath);
		//ѡ����
		BufferedOutputStream bos = null;//�����
		SequenceInputStream sis = null;//������
		
		//����һ����������װ���е�������֮������Sequence
		Vector<InputStream> vi = new Vector<InputStream>();
		
		try {
			for(int i=0;i<this.blockPath.size();i++){
				vi.add(new BufferedInputStream(new FileInputStream(new File(this.blockPath.get(i)))));
			}

			bos = new BufferedOutputStream(new FileOutputStream(dest,true));//׷�� true
			sis = new SequenceInputStream(vi.elements());//util�����vector�ӿڵ�elementsö�ٷ���

			//������
			byte[] flush = new byte[1024];
			//���ճ���
			int len = 0;
			while(-1!=(len=sis.read(flush))){
				System.out.println(new String(flush,0,len));
				bos.write(flush,0,len);
			}
			bos.flush();
			FileCloseUtil.close(sis);
		}catch (Exception e) {//alt+shift+z
		}finally{
			FileCloseUtil.close(bos);
		}
	}
	
	
	
	public static void main(String[] args) {
		
		SplitFileSequence splitfile = new SplitFileSequence("D:/informatique/MyEclipse workspace/testIO/parent/1.txt","D:/informatique/MyEclipse workspace/testIO/parent/",600);
//		System.out.println(splitfile.num);
//		splitfile.split();
		
		splitfile.merge("D:/informatique/MyEclipse workspace/testIO/parent/merge.txt");
	}
	
	
	
}
