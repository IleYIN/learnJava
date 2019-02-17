package utils;

import bean.ColumnInfo;
import bean.JavaFieldGetSet;
import core.TypeConvertor;

/**
 * 封装了生成Java文件（源代码）的常用操作
 */
public class JavaFileUtils {

	/**
	 * 根据字段信息生产java属性信息，如：var username-->private String username；以及相应的set和get方法源码
	 * @param column 字段信息
	 * @param convertor 类型转化信息
	 * @return java属性和set/get方法源码
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
