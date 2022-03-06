package validation;

import myExceptions.InvalidInputDaysException;

public class ValidateNumberOfDays {
	static public ValidateNumberOfDays tester = new ValidateNumberOfDays();

	private ValidateNumberOfDays() {
	}
	
	public boolean checkNumberOfDaysToBEeAdded(int n) {
		if(n<0) throw new InvalidInputDaysException();
		return true;

//		 && checkYear() && checkMonth())
//			return true;

//		return false;
	}
}
