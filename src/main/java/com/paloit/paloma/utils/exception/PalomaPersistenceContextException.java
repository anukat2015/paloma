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
public class PalomaPersistenceContextException extends PalomaException {
	/**
	 * Generate serial UID
	 */
	private static final long serialVersionUID = 1010867561785557201L;

	/**
	 * Default construction
	 */
	public PalomaPersistenceContextException() {
		super();
	}

	/**
	 * @param message The message to attach with
	 * the exception
	 */
	public PalomaPersistenceContextException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public PalomaPersistenceContextException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public PalomaPersistenceContextException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public PalomaPersistenceContextException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
