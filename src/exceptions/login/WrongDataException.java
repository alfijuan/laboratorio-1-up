package exceptions.login;

@SuppressWarnings("serial")
public class WrongDataException extends Exception{

	public WrongDataException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WrongDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public WrongDataException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public WrongDataException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public WrongDataException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
