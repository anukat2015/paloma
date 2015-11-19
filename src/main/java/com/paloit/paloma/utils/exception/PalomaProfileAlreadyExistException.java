/**
 * 
 */
package com.paloit.paloma.utils.exception;

/**
 * @author SLOPESNEVES
 * Error to throw when a profile is create with 
 * an existing first name and last name
 *
 */
public class PalomaProfileAlreadyExistException extends PalomaException {

	/**
	 * The generated serial UID
	 */
	private static final long serialVersionUID = 9164024766033038555L;

	/**
	 * 
	 */
	public PalomaProfileAlreadyExistException() {
		super();
	}

	/**
	 * @param message
	 */
	public PalomaProfileAlreadyExistException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public PalomaProfileAlreadyExistException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public PalomaProfileAlreadyExistException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public PalomaProfileAlreadyExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
