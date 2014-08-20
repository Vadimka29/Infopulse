package filters;
import java.io.File;
import java.io.FileFilter;


public class FileOnly implements FileFilter {

	@Override
	public boolean accept(File f) {
		return f.isFile();
	}
	
}
