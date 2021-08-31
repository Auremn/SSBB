package model.exceptions;

@SuppressWarnings("serial")
public class InitException extends Exception {

	public InitException(String message, Throwable cause) {
		super(message, cause);
	}

	public InitException(String message) {
		super(message);
	}

}
