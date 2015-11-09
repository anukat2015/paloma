/**
 * 
 */
package com.paloit.paloma.user;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.paloit.paloma.domain.User;
import com.paloit.paloma.dto.GoogleUserDTO;
import com.paloit.paloma.google.GoogleUserService;
import com.paloit.paloma.utils.exception.PaloITDomainRestrictionException;
import com.paloit.paloma.utils.exception.PalomaException;

/**
 * @author SLOPESNEVES, DTRANG
 * @version 0.0.1
 * Controller used to handle the authentication 
 * in the application
 *
 */
@RestController
@RequestMapping(value="/authentication")
public class AuthenticationController {
	/**
	 * Service used to get Google user from 
	 * Google SSO WS
	 */
	@Autowired
	private GoogleUserService googleUserService;
	
	/**
	 * Service used to find and create user
	 */
	@Autowired
	private UserService userService;
	
	
	/**
	 * Manage the authentication by Google SSO
	 * @param code The code provide by Google SSO WS
	 */
	@RequestMapping(method = RequestMethod.GET)
	@Transactional
	public @ResponseBody User authentication(@RequestParam String code) 
			throws PalomaException{
		GoogleUserDTO googleUser = null;
		User user = null;
		try {
			googleUser = this.googleUserService.create(code);
			
			if(!this.googleUserService.isMemberOfPaloITDomain(googleUser)){
				//TODO Add warn logger
				throw new PaloITDomainRestrictionException("The user " + googleUser + " is not allowed to log in this application");
			}else{
				user = this.userService.find(googleUser);
				if(user == null){
					user = this.userService.create();
					user.setFirstName(googleUser.getFirstName());
					user.setLastName(googleUser.getFamilyName());
					user.setGoogleId(googleUser.getId());
					user.setEmail(googleUser.getEmail());
					user.setCreatedDate(Calendar.getInstance());
					user = this.userService.update(user);
				}
			}
			
			return user;
		} catch (PalomaException e) {
			String message = this + " fail the authentication from the code : "
					+ code;
			//TODO Add error logger
			throw new PalomaException(message);
		}
	}
	
	
}
