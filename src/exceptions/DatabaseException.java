package exceptions;

public class DatabaseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -823659974070558161L;

	public DatabaseException(String message)
	{
		super(message);
	}
	
	public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
