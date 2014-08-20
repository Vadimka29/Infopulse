package finder;
import java.io.*;
import java.util.ArrayList;

public class Controller {
	public ArrayList<File> getFiles(String path, FileFilter filter){
		File f = new File(path);
		ArrayList<File> list = new ArrayList<>();
		File[] acceptedFiles = f.listFiles(filter);
		if(acceptedFiles != null){
			for(File t: acceptedFiles)
				list.add(t);
		}
		File[] fds = f.listFiles();
		if(fds == null)
			return null;
		for(File t: fds){
			if(t.isDirectory()){
				list.addAll(getFiles(t.getPath(), filter));
			}
		}
		return list;
	}
}
