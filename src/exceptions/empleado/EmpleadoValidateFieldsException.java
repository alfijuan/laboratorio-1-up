package exceptions.empleado;

@SuppressWarnings("serial")
public class EmpleadoValidateFieldsException extends Exception{

	public EmpleadoValidateFieldsException() {
		super();
	}

	public EmpleadoValidateFieldsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmpleadoValidateFieldsException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmpleadoValidateFieldsException(String message) {
		super(message);
	}

	public EmpleadoValidateFieldsException(Throwable cause) {
		super(cause);
	}

}
