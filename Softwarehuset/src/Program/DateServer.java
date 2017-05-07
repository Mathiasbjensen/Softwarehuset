package Program;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class DateServer {
	public static void main(String[] args){
//		Calendar.getInstance();
		Calendar calendar = new GregorianCalendar();
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		System.out.println(year);
		int week = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
		System.out.println(week);
		
		int day = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
		System.out.println(day);
		
	}
	
	public int getYear() {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		return year-2000;
	}
	
	public int getWeek() {
		int week = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
		return week;
	}
	
	public int getDay() {
		int day = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
		return day;
	}

}
