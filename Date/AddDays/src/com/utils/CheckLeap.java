package com.utils;

public class CheckLeap {
	public static boolean isLeap(int y) {
		if (y % 4 == 0 && y % 100 != 0)
			return true;
		if (y % 400 == 0)
			return true;
		return false;
	}
}
