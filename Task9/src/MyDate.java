import java.io.ObjectInputStream.GetField;



public class MyDate {
	private long s;
	private long min;
	private long h;
	private int dayOfWeek;
	private Day d;
	private int dayOfMonth;
	private int month;
	private Month m;
	private int year = 1970;
	
	public MyDate(long ms){
		s = (ms/1000) % 60;
		min = (ms/60_000) % 60;
		h = ((ms/3600000) % 60 + 3)%12;
		dayOfWeek = (int)((((ms/3600000) + 3)/24) % 7) ;
		//determine day constant
		switch (dayOfWeek) {
		case 0:
			d = Day.Thursday;
			break;
		case 1:
			d = Day.Friday;
			break;
		case 2:
			d = Day.Saturday;
			break;
		case 3:
			d = Day.Sunday;
			break;
		case 4:
			d = Day.Monday;
			break;
		case 5:
			d = Day.Tuesday;
			break;
		case 6:
			d = Day.Wednesday;
			break;
		}
		dayOfMonth = (int) (((ms/3600000) + 3)/24);
		for(;;){
			if(dayOfMonth < 365)
				break;
			if(isLeapYear(year)){
				dayOfMonth -= 366;
			}
			else
				dayOfMonth -= 365;
			year ++;
		}
		//day count in each month
		int[] dayCounter;
		if(isLeapYear(year)){
			dayCounter = new int[]{31,29,31,30,31,30,31,31,30,31,30,31};
		}
		else{
			dayCounter = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
		}
		int i = 0;
		for(;;){
			if(dayOfMonth - dayCounter[i] < 0)
				break;
			dayOfMonth -= dayCounter[i];
			i++;
		}
		dayOfMonth += 1;
		month = i + 1;
		switch (month) {
		case 1:
			m = Month.JANUARY;
			break;
		case 2:
			m = Month.FEBRUARY;
			break;
		case 3:
			m = Month.MARCH;
			break;
		case 4:
			m = Month.APRIL;
			break;
		case 5:
			m = Month.MAY;
			break;
		case 6:
			m = Month.JUNE;
			break;
		case 7:
			m = Month.JULY;
			break;
		case 8:
			m = Month.AUGUST;
			break;
		case 9:
			m = Month.SEPTEMBER;
			break;
		case 10:
			m = Month.OCTOBER;
			break;
		case 11:
			m = Month.NOVEMBER;
			break;
		case 12:
			m = Month.DECEMBER;
			break;
		}
	}
	@Override
	public String toString(){
		String toReturn = "[";
		toReturn += "year: " + year + ", ";
		toReturn += "month: " + m + ", ";
		toReturn += "dayOfMonth: " + dayOfMonth + ", ";
		toReturn += "day: " + d + ", ";
		toReturn += "hours: " + h + ", ";
		toReturn += "minutes: " + min + ", ";
		toReturn += "seconds: " + s + ",";
		toReturn += "]";
		return toReturn;
	}
	public boolean isLeapYear(int y){
		if(y % 4 == 0){
			if(y % 100 == 0){
				if(y % 400 == 0)
					return true;
				else
					return false;
			}
			else
				return true;
		}
		else
			return false;
	}
}
