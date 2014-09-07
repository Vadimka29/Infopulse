import java.io.IOException;


public class DStrTest extends Thread {
	int max;
	
	Appendable ap;
	public DStrTest(int m, Appendable a){
		max = m;
		ap = a;
	}
	public void run(){
		for(int i = 1; i <= max; i++){
			try {
				ap.append("a");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
