import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import filters.*;

public class Lection12 {
	public static void main(String[] args){
		File dir = new File("/media/vadim/12EAE1C3EAE1A369");
		File[] files = dir.listFiles(new DirsWithLastModified());
		for(File f: files){
			System.out.println(f.getName() );
		}
		/*String path = new String("/home/vadim/Загрузки/pre_trainee.doc");
		try{
			Scanner sc = new Scanner(new File(path));
			System.out.println(sc.hasNextLine());
			while(sc.hasNextLine()){
				String line = sc.nextLine();
				System.out.println(line);
			}
			sc.close();
		}
		catch(Exception e){
			System.out.println("ошибка" + e);
		}
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		Sotr s = new Sotr("Max", new int[]{1,2});
		String path = new String("/media/vadim/0484FD0484FCF8CE/file.bin");
		try(FileOutputStream fs = 
				new FileOutputStream(path);
				ObjectOutputStream oos = new ObjectOutputStream(fs)){
			oos.writeBoolean(true);
			oos.writeDouble(Math.PI);
			oos.writeObject("Java");
			oos.writeObject(list);
			oos.writeObject(s);
			oos.close();
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			System.out.println(ois.readBoolean());
			System.out.println(ois.readDouble());
			System.out.println(ois.readObject());
			System.out.println(ois.readObject());
			System.out.println(ois.readObject());
			
		}
		catch(Exception e){
			System.out.println(e.getStackTrace());
		}
		String path = new String("/home/vadim/Загрузки/My new CV.pdf");
		FileReader fr;
		BufferedReader br;
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null){
				System.out.println(line);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
	}
}
