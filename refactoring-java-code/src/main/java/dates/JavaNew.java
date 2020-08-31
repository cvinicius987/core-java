package dates;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JavaNew implements Dates{

	public static void main(String[] args) {
		
		var localDateExample = new JavaNew();
		
		localDateExample.exec();
	}

	@Override
	public void newDateMinusTenMonths() {

		var time = LocalDateTime.now().plusMonths(10);
		
		System.out.println(time.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
	}

	@Override
	public void createCalendar() {
		
		var start = LocalDateTime.now().minusDays(10);
				
		var end   = LocalDateTime.now();
		
		while(start.isAfter(end)) {
			
			start.plusDays(1);
			
			System.out.println(start.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		}
	}
}