package exceptions.empleado;

@SuppressWarnings("serial")
public class EmpleadoAlreadyExists extends Exception{

	public EmpleadoAlreadyExists() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmpleadoAlreadyExists(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public EmpleadoAlreadyExists(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public EmpleadoAlreadyExists(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public EmpleadoAlreadyExists(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}