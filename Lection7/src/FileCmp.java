import java.util.Comparator;
import java.io.File;

public class FileCmp implements Comparator<File> {
	
	@Override
	public int compare(File o1, File o2) {
		if(o1.length() == o2.length())
			return 0;
		if(o1.length() - o2.length() > 0)
			return 1;
		return -1;
	}
}