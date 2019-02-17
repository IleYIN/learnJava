package utils;

import bean.ColumnInfo;
import bean.JavaFieldGetSet;
import core.TypeConvertor;

/**
 * ��װ������Java�ļ���Դ���룩�ĳ��ò���
 */
public class JavaFileUtils {

	/**
	 * �����ֶ���Ϣ����java������Ϣ���磺var username-->private String username���Լ���Ӧ��set��get����Դ��
	 * @param column �ֶ���Ϣ
	 * @param convertor ����ת����Ϣ
	 * @return java���Ժ�set/get����Դ��
	 */
	public static JavaFieldGetSet createFieldGetSetSRC(ColumnInfo column,TypeConvertor convertor) {
		
		JavaFieldGetSet jfgs = new JavaFieldGetSet();
		
		String javaFieldType = convertor.databaseType2JavaType(column.getDataType());
		
		jfgs.setFieldInfo("\tprivate "+javaFieldType+" "+column.getName()+";\n" );
		
		//public String getUsername(){return username;}
		StringBuilder getSrc = new StringBuilder();
		getSrc.append("\tpublic "+javaFieldType+" get"+StringUtils.firstChar2UpperCase(column.getName())+"(){\n");
		getSrc.append("\t\treturn "+column.getName()+";\n");
		getSrc.append("\t}\n");
		
		jfgs.setGetInfo(getSrc.toString());

		//public void setUsername(String username){this.username = username;}
		StringBuilder setSrc = new StringBuilder();
		getSrc.append(javaFieldType+" "+column.getName()+"){\n");
		getSrc.append("\t\tthis."+column.getName()+"="+column.getName()+";\n");
		getSrc.append("\t}\n");
		
		jfgs.setSetInfo(setSrc.toString());
		return jfgs;
	}
}
