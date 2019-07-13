package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.ColumnInfo;
import bean.JavaFieldGetSet;
import bean.TableInfo;
import core.DBManager;
import core.PostgresqlTypeConvertor;
import core.TableContext;
import core.TypeConvertor;

/**
 * ��װ������Java�ļ���Դ���룩�ĳ��ò���
 */
public class JavaFileUtils {

	/**
	 * �����ֶ���Ϣ����java������Ϣ���磺var username תΪ private String username���Լ���Ӧ��set��get����Դ��
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
		setSrc.append("\tpublic void set"+StringUtils.firstChar2UpperCase(column.getName())+"(");
		setSrc.append(javaFieldType+" "+column.getName()+"){\n");
		setSrc.append("\t\tthis."+column.getName()+"="+column.getName()+";\n");
		setSrc.append("\t}\n");

		jfgs.setSetInfo(setSrc.toString());
		return jfgs;
	}

	/**
	 * ���ݱ���Ϣ����java���Դ����
	 * @param tableInfo ����Ϣ
	 * @param convertor ��������ת����
	 * @return java���Դ����
	 */
	public static String createJavaSrc(TableInfo tableInfo, TypeConvertor convertor) {

		Map<String,ColumnInfo> columns = tableInfo.getColumns();
		List<JavaFieldGetSet> javaFields = new ArrayList<JavaFieldGetSet>();

		for(ColumnInfo c:columns.values()) {
			javaFields.add(createFieldGetSetSRC(c, convertor));
		}

		StringBuilder src = new StringBuilder();

		//����package���
		src.append("package " + DBManager.getConf().getPoPackage()+";\n\n");

		//����import���
		src.append("import java.sql.*;\n");
		src.append("import java.util.*;\n\n");

		//�������������
		src.append("public class "+StringUtils.firstChar2UpperCase(tableInfo.getTname())+" {\n\n");

		//���������б�
		for(JavaFieldGetSet f:javaFields) {
			src.append(f.getFieldInfo());
		}
		src.append("\n\n");

		//����get�����б�
		for(JavaFieldGetSet f:javaFields) {
			src.append(f.getGetInfo());
		}

		//����set�����б�
		for(JavaFieldGetSet f:javaFields) {
			src.append(f.getSetInfo());
		}

		//���������
		src.append("}\n");

//		System.out.println(src);
		return src.toString();
	}


	public static void createJavaPOFile(TableInfo tableInfo, TypeConvertor convertor) {
		String src = createJavaSrc(tableInfo, convertor);

		String srcPath = DBManager.getConf().getSrcPath()+"\\";
		
		//Java�е�������ʽת���ַ���Ҫһ�ܱ����ܣ� �����ַ·���Ļ����Ի���"\\\\"��"/"
		String packagePath = DBManager.getConf().getPoPackage().replaceAll("\\.","/");
		
		File f = new File(srcPath+packagePath);
//		System.out.println(f.getAbsolutePath()+"***************");
		
		if(!f.exists()) {
			f.mkdirs();
		}
		
		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter(f.getAbsolutePath()+"/"+StringUtils.firstChar2UpperCase(tableInfo.getTname()+".java")));
			bw.write(src);
			
			System.out.println("������"+tableInfo.getTname()+"��Ӧ��java�ࣺ"+StringUtils.firstChar2UpperCase(tableInfo.getTname())+".java");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw!=null) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}


	/*
	//only for tests
	public static void main(String[] args) {
		//		ColumnInfo ci = new ColumnInfo("username","varchar",0);
		//		ColumnInfo ci = new ColumnInfo("id","int4",0);
		//		JavaFieldGetSet f =createFieldGetSetSRC(ci, new SqlTypeConvertor());
		//		System.out.println(f);

		Map<String,TableInfo> map = TableContext.tables;
//		TableInfo t = map.get("emp");
//		createJavaSrc(t, new SqlTypeConvertor());
//		createJavaPOFile(t, new SqlTypeConvertor());
		
		for(TableInfo t:map.values()) {
			createJavaPOFile(t, new SqlTypeConvertor());
		}
	}
	*/
}

