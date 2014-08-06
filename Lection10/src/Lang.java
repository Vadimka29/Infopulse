
public enum Lang {
	EN, UA,FR;
	
	public static String getYes(Lang l){
		String[] m = {"Exit", "Вихід? ", "Quiter?"};
		//ordinal - порядковый номер константы в enum
		return m[l.ordinal()];
		
	}
}
