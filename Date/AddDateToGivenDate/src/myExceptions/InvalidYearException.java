package myExceptions;

public class InvalidYearException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidYearException() {
		super("Invalid Year");
	}
}
