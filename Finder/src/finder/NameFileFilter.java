package finder;

import java.io.File;
import java.io.FileFilter;

public class NameFileFilter implements FileFilter {
	private String findKey;

	public NameFileFilter(String findKey) {
		this.findKey = findKey;
	}

	@Override
	public boolean accept(File pathname) {
		if (pathname.isFile()) {
			String fileName = pathname.getName();
			if (fileName.contains(findKey))
				return true;
			return false;

		}
		return false;
	}

}
