package exceptions;

public class BusinessLogicException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -823659974070558161L;

	public BusinessLogicException(String message)
	{
		super(message);
	}
	
	public BusinessLogicException(String message, Throwable cause) {
        super(message, cause);
    }
}
