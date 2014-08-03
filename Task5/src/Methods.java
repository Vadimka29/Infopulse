import java.io.*;


public class Methods {
	public static int counter = 0;
	/**
	 * Gets number's digits.
	 * @param number - number,which will be broken into digits.
	 * @return MyList with digits.
	 */
	public static MyList getNumberDigits(int number){
		MyList lst = new MyList();
		//count the digits
		while(number != 0){
			lst.add(number % 10);
			number /= 10;
		}
		lst.reverse();
		return lst;
	}
	/**
	 * Write class ArrayWriter
	 * @param path - path to src folder of project
	 */
	public static void arrayClassWriter(String path){
		StringBuffer str = new StringBuffer();
		for(int i = 0; i < 8_200; i++){
			long temp = (long)(Math.random()*8_201);
			str.append(temp);
			str.append(",");
		}
		try{
			File f = new File(path);
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("public class ArrayWriter {");
			bw.newLine();
			bw.write("    public long[] array = {");
			bw.write(str.toString());
			bw.write("};");
			bw.newLine();
			bw.write("}");
			bw.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public static void recursion(){
		Methods.counter ++;
		System.out.println(Methods.counter);
		recursion();
	}
}
