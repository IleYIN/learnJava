package core;
/**
 * sql数据类型和java数据类型的转换
 * 
 * @author yinyiliang
 *
 */
public class SqlTypeConvertor implements TypeConvertor  {

	@Override
	public String databaseType2JavaType(String columnType) {
		//varchar --> String
		if("varchar".equalsIgnoreCase(columnType)||"char".equalsIgnoreCase(columnType)) {
			return "String";
		} else if ("int2".equalsIgnoreCase(columnType)||"int4".equalsIgnoreCase(columnType)) {
			return "Integer";
		} else if ("int8".equalsIgnoreCase(columnType)) {
			return "Long";
		} else if ("float4".equalsIgnoreCase(columnType)) {
			return "Float";
		} else if ("float8".equalsIgnoreCase(columnType)) {
			return "Double";
		} else if ("date".equalsIgnoreCase(columnType)) {
			return "java.sql.Date";
		} else if ("time".equalsIgnoreCase(columnType)) {
			return "java.sql.Time";
		} else if ("timestamp".equalsIgnoreCase(columnType)) {
			return "java.sql.Timestamp";
		} else if ("".equalsIgnoreCase(columnType)) {
			return "java.sql.Timestamp";
		} else if ("timestamp".equalsIgnoreCase(columnType)) {
			return "java.sql.Timestamp";
		}
		return null;
	}

	@Override
	public String javaType2DatabaseType(String javaDataType) {
		if("String".equalsIgnoreCase(javaDataType)) {
			return "varchar";
		} else if ("Integer".equalsIgnoreCase(javaDataType)) {
			return "int4";
		} else if ("Long".equalsIgnoreCase(javaDataType)) {
			return "int8";
		} else if ("Float".equalsIgnoreCase(javaDataType)) {
			return "float4";
		} else if ("Double".equalsIgnoreCase(javaDataType)) {
			return "float8";
		} else if ("java.sql.Date".equalsIgnoreCase(javaDataType)) {
			return "date";
		} else if ("java.sql.Time".equalsIgnoreCase(javaDataType)) {
			return "time";
		} else if ("java.sql.Timestamp".equalsIgnoreCase(javaDataType)) {
			return "timestamp";
		}
		return null;
	}

}

