package myExceptions;

public class InvalidMonthException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidMonthException() {
		super("Invalid Month");
	}
}
