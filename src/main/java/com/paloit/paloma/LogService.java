/**
 * 
 */
package com.paloit.paloma;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * @author SLOPESNEVES
 *
 */
@Service
public class LogService {

	/**
	 * The logger
	 */
	private Logger logger;
	
	@PostConstruct
	private void init() {
		this.logger = LogManager.getFormatterLogger();
	}
	
	
	/**
	 * 
	 * @return The logger
	 */
	public Logger getLogger() {
		return this.logger;
	}

}
