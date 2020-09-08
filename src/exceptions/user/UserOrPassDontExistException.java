package exceptions.user;

public class UserOrPassDontExistException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2170183617629252689L;

	public UserOrPassDontExistException() {
		super();
	}

	public UserOrPassDontExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace); 
	}

	public UserOrPassDontExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserOrPassDontExistException(String message) {
		super(message);
	}

	public UserOrPassDontExistException(Throwable cause) {
		super(cause);
	}
}
