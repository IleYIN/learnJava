package composite;

public class Client {

	public static void main(String[] args) {
		AbstractFile f1, f2, f3, f4, f5;
		f1 = new Folder("my documents");
		f2 = new ImageFile("img.jpg");
		f3 = new TextFile("hi.txt");
		
		Folder f01 = (Folder) f1;
		f01.add(f2);
		f01.add(f3);
		
//		f2.killVirus();
//		f1.killVirus();
		
		Folder f11 = new Folder("films");
		f4 = new VideoFile("film1.avi");
		f5 = new VideoFile("film2.avi");
		f11.add(f4);
		f11.add(f5);
		f01.add(f11);
		
		f1.killVirus();
	}
}
