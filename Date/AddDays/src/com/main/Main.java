package com.main;

import java.util.Scanner;

import com.pojo.Date;
import com.utils.CheckLeap;
import com.utils.Validation;

public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		System.out.println("enter date(dd/mm/yyyy): ");
		String date = scn.nextLine();
		System.out.println("enter no of days: ");
		int n = scn.nextInt();
		Date inputDate = getInputDate(date);
		if (Validation.IsValidDate(inputDate)) {
			getDateAfterNDays(inputDate, n);
		}
	}

	private static Date getInputDate(String date) {
		String[] temp = date.split("/", 3);
		return new Date(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
	}

	private static void getDateAfterNDays(Date date, int n) {
		n += date.getDay();
		Date tmp = date;
		
//		while (n > 365) {
//			if (n > 365) {
//				tmp.setYear(tmp.getYear() + 1);
//				n -= 365;
//				if (CheckLeap.isLeap(tmp.getYear()))
//					n--;
//			}
//		}
		
		while (true) {
			int m = getDaysInMonth(tmp);
			if (n > m) {
				n -= m;
				tmp.setMonth(tmp.getMonth() + 1);

				if (tmp.getMonth() > 12) {
					tmp.setYear(tmp.getYear() + 1);
					tmp.setMonth(1);
				}
			} else {
				tmp.setDay(n);
				break;
			}
		}
		System.out.println(tmp);
	}

	private static int getDaysInMonth(Date date) {
		int[] daysInMonth = { -1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (CheckLeap.isLeap(date.getYear())) {
			daysInMonth[2] = 29;
		} else {
			daysInMonth[2] = 28;
		}
		return daysInMonth[date.getMonth()];
	}
}