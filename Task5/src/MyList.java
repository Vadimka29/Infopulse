import java.io.*;
import java.util.Arrays;

//Переделать!!! нужно при каждом добавлении элемента выделять в два раза
//больше памяти, чем под предидущий массив.

public class MyList {
	private int[] array;
	
	//constructors
	public MyList(){
		array = new int[]{};
	}
	public MyList(int[] array){
		this.array = array;
	}
	@Override
	public String toString(){
		return Arrays.toString(array);
	}
	/**
	 * Gives the number of elements in MyList.
	 * @return length of MyList.
	 */
	public int length(){
		return array.length;
	}
	/**
	 * Adds one value at the end of MyList.
	 * @param value -  this integer will be added at the end of MyList.
	 */
	public void add(int value){
		int length = array.length + 1;
		int[] temp = array.clone();
		array = new int[length];
		//copy old data
		for(int i = 0; i < temp.length; i ++)
			array[i] = temp[i];
		//insert new value
		array[length - 1] = value;
	}
	/**
	 * Adds whole array at the end of MyList
	 * @param mass - array, which will be inserted at the end of MyList. 
	 */
	public void add(int[] mass){
		int length = array.length + mass.length;
		int[] temp = array.clone();
		array = new int[length];
		// copy old data
		for (int i = 0; i < temp.length; i++)
			array[i] = temp[i];
		//insert new data
		for(int j = temp.length; j < length; j++)
			array[j] = mass[j - temp.length];
	}

	/**
	 * Returns MyList array representation.
	 * @return array of integers.
	 */
	int[] toArray(){
		return array;
	}
	/**
	 * Gives the element of MyList at position [index]. 
	 * @param index - index of element in MyList
	 * @return element of MyList at position [index].
	 */
	public int get(int index){
		//if index is incorrect
		if(index < 0 || index >= array.length)
			throw new ArrayIndexOutOfBoundsException();
		return array[index];
	}
	/**
	 * Sets new value of MyList element at position [index].
	 * @param index - position of the element in MyList.
	 * @param value - new value of element if MyList. 
	 */
	public void set(int index, int value){
		// if index is incorrect
		if (index < 0 || index >= array.length)
			throw new ArrayIndexOutOfBoundsException();
		array[index] = value;
	}
	/**
	 * Removes MyList element at position [index].
	 * @param index - position of element, which will be removed.
	 */
	public void remove(int index) {
		// if index is incorrect
		if (index < 0 || index >= array.length)
			throw new ArrayIndexOutOfBoundsException();
		int length = array.length - 1;
		int[] temp = array.clone();
		array = new int[length];
		//copy old values without temp[index]
		for(int i = 0; i < index; i ++)
			array[i] = temp[i];
		for(int i = index + 1; i < length; i ++)
			array[i] = temp[i];
	}
	/**
	 * Writes MyList elements into MyList.txt.
	 * @param path - MyList.txt will be created in this folder.
	 * @return writing status.
	 */
	public boolean writeToFile(String path){
		try{
			File f = new File(path + "/MyList.txt");
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(this.toString());
			bw.close();
			return true;
		}
		catch(NullPointerException | IOException e){
			System.out.println("Exception: " + e);
			return false;
		}
		
	}
	public void reverse(){
		for(int i = 0; i < array.length / 2; i++){
			int temp = array[i];
			array[i] = array[array.length - i - 1];
			array[array.length - i - 1] = temp;
		}
	}
}
