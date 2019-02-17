package testException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestReadFileThrows {
	public static void main(String[] args) {
		try {
			String str = new TestReadFileThrows().openFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	String openFile() throws FileNotFoundException, IOException{ //throws表示谁调用我谁来处理异常
		FileReader reader = new FileReader("pw.txt");
		char c = (char)reader.read();
		return("");
	}
}
