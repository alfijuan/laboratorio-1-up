package exceptions.tarea;

@SuppressWarnings("serial")
public class TareaAlreadyExists extends Exception{

	public TareaAlreadyExists() {
		super();
	}

	public TareaAlreadyExists(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TareaAlreadyExists(String message, Throwable cause) {
		super(message, cause);
	}

	public TareaAlreadyExists(String message) {
		super(message);
	}

	public TareaAlreadyExists(Throwable cause) {
		super(cause);
	}

}