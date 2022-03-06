package myExceptions;

public class InvalidDayException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidDayException() {
		super("Invalid Day for the Date");
	}
}
