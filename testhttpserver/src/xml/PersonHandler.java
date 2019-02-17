package xml;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * �洢����
 * @author yinyiliang
 *
 */

public class PersonHandler extends DefaultHandler {

	private List<Person> persons;
	private Person person;
	private String tag;//��¼��ǩ��
	
	
	
	@Override
	public void startDocument() throws SAXException {

		//System.out.println("�����ĵ���ʼ");
		persons = new ArrayList<Person>();
	}
		

	@Override
	public void startElement(String uri, String localname, String qname, Attributes attributes) throws SAXException {
		//System.out.println("��ʼһ��Ԫ��"+qname);
		if(null!=qname) {
			tag = qname;
		}
		if(null!=qname && qname.equals("person")) {
			person = new Person();
		}
		
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		//System.out.println(new String(ch, start, length));
		String str = new String(ch, start, length);
		if(null!=tag && tag.equals("name")) {
			person.setName(str);
		} else if(null!= tag && tag.equals("age")){
			Integer age = Integer.valueOf(str);
			person.setAge(age);
		}
	}
	
	
	@Override
	public void endElement(String uri, String localname, String qname) throws SAXException {
		//System.out.println("����һ��Ԫ��"+qname);
		if(qname.equals("person")) {
			this.persons.add(person);
		}
		tag = null;//��ʾ���person�Ѿ�������
	}
	
	@Override
	public void endDocument() throws SAXException {
		//System.out.println("�����ĵ�����");
	}


	public List<Person> getPersons() {
		return persons;
	}

	
}
