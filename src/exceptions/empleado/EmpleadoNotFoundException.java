package exceptions.empleado;

@SuppressWarnings("serial")
public class EmpleadoNotFoundException extends Exception{

	public EmpleadoNotFoundException() {
		super();
	}

	public EmpleadoNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmpleadoNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmpleadoNotFoundException(String message) {
		super(message);
	}

	public EmpleadoNotFoundException(Throwable cause) {
		super(cause);
	}

}
