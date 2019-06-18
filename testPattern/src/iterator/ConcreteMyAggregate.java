package iterator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteMyAggregate {

	private List<Object> list = new ArrayList<Object>();

	public ConcreteMyAggregate() {
	}
	
	public void addObject(Object obj) {
		this.list.add(obj);
	}
	
	public void removeObject(Object obj) {
		this.list.remove(obj);
	}

	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}
	
	public MyIterator createIterator() {
		return new ConcreteIterator();
	}
	
	
	//use inner class to define iterator, then it can use directly the attributes of outer class
	private class ConcreteIterator implements MyIterator {

//		private int cursor;//define a cursor to facilitate the recording of position
		private int cursor = list.size() - 1;//define a cursor to facilitate the recording of position
		
		@Override
		public void first() {
//			cursor = 0;
			cursor = list.size() - 1;
		}

		@Override
		public void next() {
//			if(cursor<list.size()) {
//				cursor++;
//			}
			if(cursor>=0) {
				cursor--;
			}
		}

		@Override
		public boolean hasNext() {
//			if(cursor<list.size()) {
//				return true;
//			}
			if(cursor>=0) {
				return true;
			}
			return false;
		}

		@Override
		public boolean isFirst() {
//			return cursor==0?true:false;
			return cursor==(list.size()-1)?true:false;
		}

		@Override
		public boolean isLast() {
//			return cursor==(list.size()-1)?true:false;
			return cursor==0?true:false;
		}

		@Override
		public Object getCurrentObj() {
			return list.get(cursor);
		}
		
	}
}
