package dates;

public interface Dates {

	default void exec() {
		
		System.out.println(" ============================ ");
		this.newDateMinusTenMonths();
		System.out.println(" ============================ ");
		
		System.out.println(" ============================ ");
		this.createCalendar();
		System.out.println(" ============================ ");
	}
	
	void newDateMinusTenMonths();
		
	void createCalendar();
}