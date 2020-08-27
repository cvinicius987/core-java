package dates;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class CalendarExample implements Dates{

	public static void main(String[] args) {
				
		CalendarExample calendarMain = new CalendarExample();
		
		System.out.println(" ============================ ");
		calendarMain.newDateMinusTenMonths();
		System.out.println(" ============================ ");
		
		System.out.println(" ============================ ");
		calendarMain.timezone();
		System.out.println(" ============================ ");
		
		System.out.println(" ============================ ");
		calendarMain.createCalendar();
		System.out.println(" ============================ ");
	}

	@Override
	public void newDateMinusTenMonths() {
		
		Calendar today = Calendar.getInstance();
		
		today.add(Calendar.MONTH, 10);
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		System.out.println(format.format(today.getTime()));
	}

	@Override
	public void timezone() {
		
		TimeZone timezone = TimeZone.getTimeZone("JST");
		
		Calendar today = Calendar.getInstance(timezone);
		
		today.setTimeZone(timezone);
		
		
	    System.out.println(today.getTime());
	}

	@Override
	public void createCalendar() {
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		Calendar start = Calendar.getInstance();
		
		start.add(Calendar.DAY_OF_MONTH, -10);
				
		Calendar end = Calendar.getInstance();
		
		while(start.get(Calendar.DAY_OF_MONTH) < end.get(Calendar.DAY_OF_MONTH)) {
			
			start.add(Calendar.DAY_OF_MONTH, 1);
			
			System.out.println(format.format(start.getTime()));
		}
	
	}
}