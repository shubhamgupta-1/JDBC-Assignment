package myExceptions;

public class InvalidInputDaysException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidInputDaysException() {
		super("Invalid input for Number of Days to be added");
	}
}