/**
 * 
 */
package com.paloit.paloma.google;

import java.io.IOException;
import java.util.Calendar;

import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paloit.paloma.LogService;
import com.paloit.paloma.domain.User;
import com.paloit.paloma.dto.GoogleUserDTO;
import com.paloit.paloma.user.UserService;
import com.paloit.paloma.utils.PalomaConstants;
import com.paloit.paloma.utils.exception.PalomaGoogleAuthenticationException;
import com.paloit.paloma.utils.exception.PalomaPersistenceContextException;

/**
 * @author SLOPESNEVES
 * @version 0.0.1
 * Service used to handle logged used from Google SSO
 *
 */
@Service
public class GoogleUserService {

	/**
	 * Helper used to get google account informations
	 */
	@Autowired
	private GoogleAuthHelper googleAuthHelper;
	
	/**
	 * Service used to find and create user
	 */
	@Autowired
	private UserService userService;
	
	/**
	 * The log service
	 */
	@Autowired
	private LogService logService;

	/**
	 * Create user DTO with the info provided 
	 * by Google SSO WS
	 * @param code The code used to find user info from Google SSO
	 * @return
	 */
	public GoogleUserDTO create(String code) 
			throws PalomaGoogleAuthenticationException{
		String jsonUserInfos = this.getUserInfo(code);
		GoogleUserDTO googleUser = this.map(jsonUserInfos);
		return googleUser;
	}
	
	/**
	 * Getting the user info from the code given in parameter
	 * @param code The code provided by Google SSO WS
	 * @return The user info
	 * @throws PalomaGoogleAuthenticationException
	 */
	private String getUserInfo(String code) 
			throws PalomaGoogleAuthenticationException{
		String jsonInfoFromGoogleSSO;
		try {
			jsonInfoFromGoogleSSO = this.googleAuthHelper.getUserInfoJson(code);
			this.getLogger().debug("Success to parse JSON Google user data");
			return jsonInfoFromGoogleSSO;
		} catch (IOException e) {
			String message = "Failed to get user info " +
					"from the code " + code;
			this.getLogger().error(message, e);
			throw new PalomaGoogleAuthenticationException(message);
		}
	}
	
	/**
	 * Return a instance of Google user
	 * mapped with the user info given in parameter
	 * @param userInfo The user info
	 * @return The mapped Google user
	 * @throws PalomaGoogleAuthenticationException 
	 */
	private GoogleUserDTO map(String userInfo) 
			throws PalomaGoogleAuthenticationException{
		GoogleUserDTO googleUser;
		try {
			googleUser = new ObjectMapper()
					.readValue(userInfo, GoogleUserDTO.class);
			this.getLogger().debug("Success to generate " + googleUser);
			return googleUser;
		} catch (IOException e) {
			String message = "Failed to parse Google user infos " +
					" from the following string :" + System.lineSeparator() 
					+ userInfo;
			this.getLogger().error(message, e);
			throw new PalomaGoogleAuthenticationException(message);
		}
	}
	
	/**
	 * Check if the google user is member 
	 * of the Palo IT domain
	 * @param googleUser The Google user
	 * @return True if the google user is member of the Palo IT domain
	 */
	public Boolean isMemberOfPaloITDomain(GoogleUserDTO googleUser) {
		return PalomaConstants.PALO_IT_DOMAIN.equals(googleUser.getDomain());
	}
	
	/**
	 * Create new user.
	 * @param googleUser User authenticated from Google SSO
	 * @return The created user
	 * @throws PalomaPersistenceContextException 
	 */
	public User create(GoogleUserDTO googleUser) throws PalomaPersistenceContextException {
		User user = this.userService.create();
		
		user.setEmail(googleUser.getEmail());
		user.setFirstName(googleUser.getFirstName());
		user.setLastName(googleUser.getFamilyName());
		user.setIsBanned(false);
		user.setCreatedDate(Calendar.getInstance());
		try{
			user = this.userService.update(user);
			this.getLogger().info("Success to create " + user);
		}catch(HibernateException e){
			String message = "Failed to create " + User.class.getSimpleName() + " from " + googleUser;
			this.getLogger().error(message, e);
			throw new PalomaPersistenceContextException(e);
		}
		return user;
	}
	
	/**
	 * Provide the authentication URL to
	 * Google SSO
	 * @return The authentication URL
	 */
	public String buildAuthenticationUrl(){
		return this.googleAuthHelper.buildLoginUrl();
	}
	
	private Logger getLogger(){
		return this.logService.getLogger();
	}
}
