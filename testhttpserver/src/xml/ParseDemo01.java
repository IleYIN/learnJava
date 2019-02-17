package xml;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class ParseDemo01 {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//��ȡ��������
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//�ӽ���������ȡ������
		SAXParser parse = factory.newSAXParser();
		//�����ĵ� ע�ᴦ����
		//��д������
		PersonHandler handler = new PersonHandler();
		parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("xml/person.xml"), handler);
		
		List<Person> persons = handler.getPersons();
		for(Person p:persons) {
			System.out.println(p.getName()+"-->"+p.getAge());
		}
	}
}