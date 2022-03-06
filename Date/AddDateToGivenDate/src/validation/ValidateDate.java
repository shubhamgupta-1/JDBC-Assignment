package validation;

import myExceptions.InvalidDayException;
import myExceptions.InvalidMonthException;
import myExceptions.InvalidYearException;

public class ValidateDate {
	private int d, m, y;
	static public ValidateDate tester = new ValidateDate();

	private ValidateDate() {
	}

	private boolean isLeap() {
		checkYear();
		if (y % 4 == 0 && y % 100 != 0)
			return true;
		if (y % 400 == 0)
			return true;
		return false;
	}

	private boolean checkMonth(int m) {
		if (m <= 0 || m > 12) {
			throw new InvalidMonthException();
		}
		return true;
	}

	private boolean checkYear() {
		if (y <= 0) {
			throw new InvalidYearException();
		}
		return true;
	}

	public int noOfDaysInMonth(int d, int m, int y) {

		checkMonth(m);

		if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12)
			return 31;

		if (m == 2) {
			return isLeap() ? 29 : 28;

		}
		return 30;
	}

	private boolean checkDay() {
		int numOfDays = noOfDaysInMonth(d, m, y);
		if (d <= 0 || d > numOfDays) {
			throw new InvalidDayException();
		}
		return true;
	}

	private boolean checkDate() {
		return checkDay() && checkYear();
	}

	public boolean checkDate(int d, int m, int y) {
		this.d = d;
		this.y = y;
		this.m = m;
		return checkDate();

	}
}
