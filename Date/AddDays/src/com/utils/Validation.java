package com.utils;

import com.exceptions.InvalidDayException;
import com.exceptions.InvalidMonthException;
import com.exceptions.InvalidYearException;
import com.pojo.Date;

public class Validation {
	
	public static boolean IsValidDate(Date date) {
		isValidYear(date);
		isValidMonth(date);
		isValidDay(date);

		return true;
	}

	private static boolean isValidYear(Date date) {
		if (date.getYear() < 2000 || date.getYear() > 2100) {
			throw new InvalidYearException();
		}
		return true;
	}

	private static boolean isValidMonth(Date date) {
		if (date.getMonth() < 1 || date.getMonth() > 12) {
			throw new InvalidMonthException();
		}
		return true;
	}

	private static boolean isValidDay(Date date) {
		int[] daysInMonth = { -1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (CheckLeap.isLeap(date.getYear())) {
			daysInMonth[2] = 29;
		}
		if (date.getDay() < 0 || date.getDay() > daysInMonth[date.getMonth()]) {
			throw new InvalidDayException();
		}
		return true;
	}
}
