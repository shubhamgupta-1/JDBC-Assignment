package com.exceptions;

public class InvalidMonthException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidMonthException() {
		super("Month should be between 1 and 12");
	}
}
