package filters;

import java.io.File;
import java.io.FileFilter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DirsWithLastModified implements FileFilter {
	private GregorianCalendar c1;
	private GregorianCalendar c2;
	
	public DirsWithLastModified(){
		c1 = new GregorianCalendar();
		c2 = new GregorianCalendar();
		c2.set(Calendar.YEAR, 2013);
	}

	@Override
	public boolean accept(File f) {
		GregorianCalendar c3 = new GregorianCalendar();
		c3.setTimeInMillis(f.lastModified());
		return (c3.before(c1) && c3.after(c2));
	}
}
