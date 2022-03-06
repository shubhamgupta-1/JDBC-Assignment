package com;

import validation.ValidateDate;


public class Date {
	private int day, month, year;
	

	public Date() {
	}

	public Date(int d, int m, int y) {
		ValidateDate.tester.checkDate(d, m, y);
		this.day = d;
		this.month = m;
		this.year = y;
	}
	
	public Date addNumOfDays(int days) {
		ValidateDate.tester.noOfDaysInMonth(day,month, year);
		return null;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
