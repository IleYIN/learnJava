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
	
	String openFile() throws FileNotFoundException, IOException{ //throws��ʾ˭������˭�������쳣
		FileReader reader = new FileReader("pw.txt");
		char c = (char)reader.read();
		return("");
	}
}
