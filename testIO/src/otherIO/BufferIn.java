package otherIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * ��װ���� ������scanner
 * 
 * @author yinyiliang
 *
 */
public class BufferIn {

	public static void main(String[] args) throws IOException {
		InputStream is = System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		System.out.println("������");
		
		String msg = br.readLine();
		System.out.println(msg);
		
	}
}
