package testpolyinnerclass;

public class Outer {
	public static void main(String[] args) {
		Face f = new Face();
		Face.Nose n = f. new Nose(); //���������ⲿ�࣬����ֱ��д�ڲ���
		//��ֱ��д	Face.Nose n2 = new Face.Nose();
		
		n.breath();

		Face.Ear e = new Face.Ear();
		e.listen();
	}
}

class Face {
	int type;
	String shape = "������";
	static String color = "����";
	
	class Nose {
		String type;
		void breath() {
			System.out.println(this.type);//�ڲ���type
			System.out.println(Face.this.type);//�ⲿ��type
			System.out.println(shape); //�������������ֱ����ָ�ⲿ��
			System.out.println("����");
		}
	}
	
	static class Ear {
		void listen() {
			//����Ǵ���ģ���Ϊ��̬�ڲ�����û����ͨ����shape�����Ǵ�����������Ǵ������ⲿ�����System.out.println(shape);
			System.out.println(color);  //���ǿ��Է����ⲿ��ľ�̬����color
			System.out.println("��");
		}
	}
}