import javax.swing.JOptionPane;



public class Lection10 {
	public static String cityInfo(City city){
		//заполнять ведущими нулями и ширина поля 3 символа
		String temp = String.format("%03d", city.getCode());
		return "our office in " + city + ", phone prefix: " + temp; 
	}
	public static void main(String[] args){
		if(JOptionPane.showConfirmDialog(null, Lang.getYes(Lang.EN))== 
				JOptionPane.OK_OPTION)
			return;
		System.out.println("application works");
		int[] m = {};
		System.out.println(m.getClass().getCanonicalName());
	}
}
