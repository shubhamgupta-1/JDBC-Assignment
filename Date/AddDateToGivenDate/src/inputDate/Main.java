package inputDate;

import com.Date;

import validation.ValidateNumberOfDays;

public class Main {
	public static void main(String[] args) {
		
		Date d=new Date(28,2,5);
		System.out.println(d);
		System.out.println(ValidateNumberOfDays.tester.checkNumberOfDaysToBEeAdded(28));
	}
}
