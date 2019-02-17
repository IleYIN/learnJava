package otherIO2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 文件的分割思路
 * 1、准备
 * 分割的块数size  n块
 * 每一块的大小 blockSize
 * 每一块的名称
 * 最后总的大小(n-1)*blockSize
 * 2、分割
 * 第几块 每块起点 实际大小
 * 文件分割
 * 
 * @author yinyiliang
 *
 */
public class RandomAccessFileTest01 {

	public static void main(String[] args) throws IOException {
		
		RandomAccessFile rnd = new RandomAccessFile(new File("D:/informatique/MyEclipse workspace/testIO/parent/1.txt"),"r");//只读
		rnd.seek(5);//从第几个字节开始走
		
		//定义缓冲大小
		byte[] flush = new byte[1024];
		//接收长度
		int len = 0;
		
		while(-1!=(len=rnd.read(flush))){
			
			if(len>=20){
				System.out.println(new String(flush,0,20));
				break;
			} else {
				System.out.println(new String(flush,0,len));
			}
		}
		
		FileCloseUtil.close(rnd);
	}
}
