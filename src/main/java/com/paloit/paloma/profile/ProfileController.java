package com.paloit.paloma.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.paloit.paloma.domain.Profile;
import com.paloit.paloma.profile.contact.ContactService;
import com.paloit.paloma.utils.exception.PalomaException;
import com.paloit.paloma.utils.exception.PalomaPersistenceContextException;

@RestController
@RequestMapping(value="/profile")
public class ProfileController {
	/**
	 * The profile service
	 */
	@Autowired
	private ProfileService profileService;
	
	
	/**
	 * The contact service
	 */
	@Autowired
	private ContactService contactService;
	
	/**
	 * Create a new profile
	 * @return The new profile
	 * @throws PalomaPersistenceContextException
	 */
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody Profile create() throws PalomaException{
		Profile profile = null;
		try{
			profile = this.profileService.create();
			profile.setContact(this.contactService.create());
			this.profileService.update(profile);
			//TODO Add info log
			return profile;
		}catch(Exception e){
			String message = this + " failed to create a new profile";
			//TODO Add error logger
			throw new PalomaException(message);
		}
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public @ResponseBody Profile update(@RequestBody Profile profile) 
			throws PalomaException{
		try{
			profile = this.profileService.update(profile);
			//TODO Add debug log
			return profile;
		}catch(Exception e){
			String message = this + " fail to update the profile " 
		+ profile + " given in parameter";
			//TODO Add error log
			throw new PalomaException(message);
		}
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public void delete(@RequestBody Profile profile)
	throws PalomaException{
		try{
			profile.setIsDeleted(Boolean.TRUE);
			this.profileService.update(profile);
			//TODO Add info log
		}catch(Exception e){
			String message = this + " failed to delete the profile " + profile;
			//TODO Add error log
			throw new PalomaException(message);
		}
	}
}
