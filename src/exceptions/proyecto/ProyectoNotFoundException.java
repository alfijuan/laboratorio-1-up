
package exceptions.proyecto;

@SuppressWarnings("serial")
public class ProyectoNotFoundException extends Exception{

	public ProyectoNotFoundException() {
		super();
	}

	public ProyectoNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ProyectoNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProyectoNotFoundException(String message) {
		super(message);
	}

	public ProyectoNotFoundException(Throwable cause) {
		super(cause);
	}

}
