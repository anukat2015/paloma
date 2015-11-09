/**
 * 
 */
package com.paloit.paloma.utils.exception;

/**
 * @author DTRANG, SLOPES
 * @version 0.0.1
 * Exception to used when there is a problem
 * with the persistence context.
 *
 */
public class PalomaGoogleAuthenticationException extends PalomaException {
	/**
	 * Generate serial UID
	 */
	private static final long serialVersionUID = 1010867561785557201L;

	/**
	 * Default construction
	 */
	public PalomaGoogleAuthenticationException() {
		super();
	}

	/**
	 * @param message The message to attach with
	 * the exception
	 */
	public PalomaGoogleAuthenticationException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public PalomaGoogleAuthenticationException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public PalomaGoogleAuthenticationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public PalomaGoogleAuthenticationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
