
package exceptions.tarea;

@SuppressWarnings("serial")
public class TareaNotFoundException extends Exception{

	public TareaNotFoundException() {
		super();
	}

	public TareaNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TareaNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public TareaNotFoundException(String message) {
		super(message);
	}

	public TareaNotFoundException(Throwable cause) {
		super(cause);
	}

}
