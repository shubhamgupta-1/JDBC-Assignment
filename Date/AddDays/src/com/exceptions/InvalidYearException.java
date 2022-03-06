package com.exceptions;

public class InvalidYearException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidYearException() {
		super("Year must be between 2000 to 2100");
	}
}
