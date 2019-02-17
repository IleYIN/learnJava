package otherIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;


/**
 * 
 * 不是所有对象和属性都可以序列化
 * 如果没有implements java.io.Serializable 会报异常 java.io.NotSerializableException
 * 
 * @author yinyiliang
 *
 */
public class ObjectTest01 {

	public static void main(String[] args) {
		
		try {
			seri("D:/informatique/MyEclipse workspace/testIO/parent/object.txt");
			read("D:/informatique/MyEclipse workspace/testIO/parent/object.txt");
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//反序列化
	public static void read(String srcPath) throws IOException, ClassNotFoundException{
		
		//创建源
		File src = new File(srcPath);

		//选择流
		ObjectInputStream ois = new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream(src)
						)
				);

		//操作 读取的顺序与写出一致 必须存在才能读取
		//不一致则数据存在问题
		Object obj = ois.readObject();
		if(obj instanceof Employee){
			
			Employee emp = (Employee)obj;
			System.out.println(emp.getName());
			System.out.println(emp.getSalary());
			
		}
		
		obj = ois.readObject();
		int[] arr = (int[])obj;
		System.out.println(Arrays.toString(arr));
		//释放
		ois.close();
	}
	
	
	//序列化
	public static void seri(String destPath) throws FileNotFoundException, IOException{
		
		Employee emp = new Employee("lalala",1000000);
		
		int[] arr = {1,3,4,5};
		
		//创建源
		File dest = new File(destPath);

		//选择流
		ObjectOutputStream dos = new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(dest)
						)
				);

		//操作 写出的顺序 为读取做准备 必须一致
		dos.writeObject(emp);
		dos.writeObject(arr);
		
		dos.flush();

		//释放
		dos.close();
	}
	
}
