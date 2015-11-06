/**
 * 
 */
package com.paloit.paloma.utils.exception;

/**
 * @author DTRANG, SLOPES
 * @version 0.0.1
 * Exception to used when a user try to authenticate
 * in the application without being from the Palo IT
 * domain.
 *
 */
public class PaloITDomainRestrictionException extends PalomaException {

	/**
	 * The generate serial UID
	 */
	private static final long serialVersionUID = 1195643678466547932L;

	/**
	 * Default construction
	 */
	public PaloITDomainRestrictionException() {
		super();
	}

	/**
	 * @param message The message to attach with
	 * the exception
	 */
	public PaloITDomainRestrictionException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public PaloITDomainRestrictionException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public PaloITDomainRestrictionException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public PaloITDomainRestrictionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
