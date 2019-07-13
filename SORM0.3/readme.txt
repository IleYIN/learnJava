1.在src下建立db.properties
2.每张表只能有一个主键，不能处理多个主键的情况。
3.po尽量使用包装类，不要使用基本数据类型
4.utf-8项目生成javadoc 编码GBK的不可映射字符问题：eclipse->Generate javadoc->最后一步中VM设置行中加入一下代码 -encoding utf-8 -charset utf-8