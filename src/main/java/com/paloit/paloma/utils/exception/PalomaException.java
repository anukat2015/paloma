/**
 * 
 */
package com.paloit.paloma.utils.exception;

/**
 * @author DTRANG
 *
 */
public class PalomaException extends Exception {
	/**
	 * The generate serial UID
	 */
	private static final long serialVersionUID = 1195643678466547932L;

	/**
	 * Default construction
	 */
	public PalomaException() {
		super();
	}

	/**
	 * @param message The message to attach with
	 * the exception
	 */
	public PalomaException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public PalomaException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public PalomaException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public PalomaException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
