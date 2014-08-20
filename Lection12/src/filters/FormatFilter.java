package filters;

import java.io.File;
import java.io.FileFilter;

public class FormatFilter implements FileFilter {
	private String ext;
	public FormatFilter(String ext) {
		this.ext = ext;
	}
	@Override
	public boolean accept(File f) {
		return f.getName().endsWith("." + ext);
	}
	
}
