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
 * 文件分割
 * 
 * @author yinyiliang
 *
 */

public class SplitFileSequence {

	private String filePath;//文件路径
	
	private String fileName;//文件名
	
	private long filelength;//文件大小
	
	private int num;//块数
	
	private long blockSize;//每块大小
	
	private String destBlockPath;//分割后的存放目录
	
	private List<String> blockPath;//用于存放每块的路径的列表
	
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
	 * 初始化操作 计算块数 
	 */
	public void init(){
		
		File src = null;
		
		//健壮性
		if( null==filePath || !( ( src=new File(filePath) ).exists() ) || src.isDirectory() ){
			return;//结束方法
		}
		
		this.fileName = src.getName();
		
		//计算块数 实际大小与每块大小
		this.filelength = src.length();
		//修正每块大小
		if(this.blockSize>filelength){
			this.blockSize = filelength;
		}
		
		//确定块数
		num = (int) Math.ceil(filelength*1.0/this.blockSize);//Math.ceil()返回大于或等于函数参数，并且与之最接近的整数
		
		initPathName();//确定每一块的存放路径
		
	}
	
	private void initPathName(){
		
		for(int i=0; i<num; i++){
			this.blockPath.add(destBlockPath + "/"+ this.fileName+"-part"+i+".txt");
		}
	}
	
	
	/**
	 * 文件分割
	 * 
	 * 第几块
	 * 起始位置
	 * 实际大小
	 * 
	 * @param destPath 分割文件存放目录
	 */
	public void split(){
		
	
		long beginPos = 0; //起始点
		long actualBlockSize = blockSize; //实际大小
		
		
		//设置每一块的开始位置(类似于游标)
		for(int i=0;i<num;i++){
			
			if(i==num-1){//最后一块的实际大小会和我们规定分割的每块大小不同,可以用总长度减去其实位置就得实际大小
				actualBlockSize = this.filelength-beginPos;
			}
			
			splitDetail(i, beginPos,actualBlockSize);
			beginPos += actualBlockSize;//本次的终点就是下一次的起点
		}
	}
	
	
	/**
	 * 文件分割  输入 输出
	 * 
	 * 文件拷贝
	 * @param index
	 * @param beginPos
	 * @param actualBlockSize
	 */
	private void splitDetail(int index, long beginPos, long actualBlockSize){
		
		//创建源
		File src = new File(this.filePath); //源文件
		File dest = new File(this.blockPath.get(index));//目标文件
		
		//选择流
		RandomAccessFile raf = null; //输入流
		BufferedOutputStream bos = null; //输出流
		
		try {
			raf = new RandomAccessFile(src,"r");//只读 随机访问
			bos = new BufferedOutputStream(new FileOutputStream(dest));
			
			//读取文件
			raf.seek(beginPos);
			//缓冲区
			byte[] flush  = new byte[1024];
			int len =0;
			while(-1!= (len=raf.read(flush))){
				
				if(actualBlockSize-len>0){
					//写出
					bos.write(flush,0,len);//只写这一行是不对的，每次都写len，如果不加actualBlockSize条件限制的话会一直读到末尾导致每个分割文件都读源文件到了末尾
					actualBlockSize-=len;//写一点 就剪掉一点 得到剩余量
					
				} else {
					//到最后一点 直接写出剩余量即可
					bos.write(flush,0,(int)actualBlockSize);
					break;//停止循环
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
	 * 文件的合并
	 * 
	 * @param args
	 */
	public void merge(String destPath){
		
		//创建源
		File dest = new File(destPath);
		//选择流
		BufferedOutputStream bos = null;//输出流
		SequenceInputStream sis = null;//输入流
		
		//创建一个容器用于装所有的输入流之后再用Sequence
		Vector<InputStream> vi = new Vector<InputStream>();
		
		try {
			for(int i=0;i<this.blockPath.size();i++){
				vi.add(new BufferedInputStream(new FileInputStream(new File(this.blockPath.get(i)))));
			}

			bos = new BufferedOutputStream(new FileOutputStream(dest,true));//追加 true
			sis = new SequenceInputStream(vi.elements());//util包里的vector接口的elements枚举方法

			//缓冲区
			byte[] flush = new byte[1024];
			//接收长度
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
