package composite;

import java.util.ArrayList;
import java.util.List;

public interface AbstractFile {
	void killVirus();
}

class ImageFile implements AbstractFile {//Leaf

	private String name;
	
	public ImageFile(String name) {
		super();
		this.name = name;
	}

	@Override
	public void killVirus() {
		System.out.println("--Image file: "+name+", check virus!");
	}
}

class TextFile implements AbstractFile {//Leaf

	private String name;
	
	public TextFile(String name) {
		super();
		this.name = name;
	}

	@Override
	public void killVirus() {
		System.out.println("--Text file: "+name+", check virus!");
	}
}

class VideoFile implements AbstractFile {//Leaf

	private String name;
	
	public VideoFile(String name) {
		super();
		this.name = name;
	}

	@Override
	public void killVirus() {
		System.out.println("--Video file: "+name+", check virus!");
	}
}


class Folder implements AbstractFile {//composite
	
	private String name;
	
	public Folder(String name) {
	super();
	this.name = name;
}

	//define a container to contain the children nodes
	private List<AbstractFile> list = new ArrayList<AbstractFile>();
	
	public void add(AbstractFile file) {
		list.add(file);
	}
	
	public void remove(AbstractFile file) {
		list.remove(file);
	}
	
	public AbstractFile getChild(int index) {
		return list.get(index);
	}
	
	@Override
	public void killVirus() {
		System.out.println("--Folder files: "+name+", check virus!");
		
		for(AbstractFile file : list) {
			file.killVirus();//iteration
		}
	}
	
}

