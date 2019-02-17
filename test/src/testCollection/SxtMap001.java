package testCollection;

/**
 * 自定义实现Map的功能
 * 暂不完美
 * Map:存放键值对，根据键对象找对应的值对象
 * 
 * @author yinyiliang
 *
 */
public class SxtMap001 {
	
	SxtEntry[] arr = new SxtEntry[990];
	int size;
	
	public void put(Object key, Object value){
		SxtEntry e = new SxtEntry(key, value);
		//键值重复的问题处理：键若重复，则需覆盖原来的value
		for(int i=0; i<size; i++){
			if (arr[i].key.equals(key)){
				arr[i].value = value;
				return;//return表示结束函数
			}
		}
		arr[size++] = e;//把值给size位，然后size++			
	}

	public Object get(Object key){
		for(int i=0; i<size; i++){
			if (arr[i].key.equals(key)){
				return arr[i].value;
			}
		}
		return null;
	}
	
	public boolean containsKey(Object key){
		for(int i=0; i<size; i++){
			if (arr[i].key.equals(key)){
				return true;
			}
		}
		return false;
	}
	
	public boolean containsValue(Object value){
		for(int i=0; i<size; i++){
			if (arr[i].value.equals(value)){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		SxtMap001 m = new SxtMap001();
		m.put("张三", new Wife("张三的妻子"));
		m.put("李四", new Wife("李四的妻子"));
		m.put("李四", new Wife("李四的二任妻子"));
		Wife w = (Wife)m.get("李四");
		System.out.println(w.name);
	}
}

class SxtEntry{
	Object key;
	Object value;
	
	public SxtEntry(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
}