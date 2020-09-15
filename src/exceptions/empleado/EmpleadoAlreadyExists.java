package exceptions.empleado;

@SuppressWarnings("serial")
public class EmpleadoAlreadyExists extends Exception{

	public EmpleadoAlreadyExists() {
		super();
	}

	public EmpleadoAlreadyExists(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmpleadoAlreadyExists(String message, Throwable cause) {
		super(message, cause);
	}

	public EmpleadoAlreadyExists(String message) {
		super(message);
	}

	public EmpleadoAlreadyExists(Throwable cause) {
		super(cause);
	}

}