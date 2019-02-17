package test01Student;

import testEncapulation.Test03;

public class TestEncap1 {
	public static void main(String[] args) {
		Test03 t = new Test03();
		t.print();//改成Test03 public 才行，protected不行
	}
}

