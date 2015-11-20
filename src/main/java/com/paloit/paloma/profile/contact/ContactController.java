package com.paloit.paloma.profile.contact;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.paloit.paloma.LogService;
import com.paloit.paloma.domain.Contact;
import com.paloit.paloma.domain.Country;
import com.paloit.paloma.domain.Profile;
import com.paloit.paloma.dto.ContactDTO;
import com.paloit.paloma.profile.ProfileService;
import com.paloit.paloma.utils.exception.PalomaException;
import com.paloit.paloma.utils.exception.PalomaPersistenceContextException;
import com.paloit.paloma.utils.exception.PalomaProfileAlreadyExistException;

@RestController
@RequestMapping(value="/contact")
@Transactional
public class ContactController {
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
	 * The log service
	 */
	@Autowired
	private LogService logService;

	/**
	 * Create a new profile
	 * @return The new profile
	 * @throws PalomaPersistenceContextException
	 */
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody public ContactDTO create(@RequestBody ContactDTO contactDTO) throws PalomaException{
		Profile profile = null;
		Contact contact = null;
		try{

			if (this.profileAlreadyExists(contactDTO)){
				String message = this + " there is already a "
						+ " profile matching " + contactDTO;
				this.getLogger().warn("Profile matching " + contactDTO + "already exists");
				throw new PalomaProfileAlreadyExistException(message);

			}else {
				profile = this.profileService.create();
				contact = this.contactService.create();
				
				profile.setContact(contact);

				profile = profileService.update(profile);

				contactDTO.setId(profile.getContact().getId());

				contactDTO = this.update(contactDTO);

				this.getLogger().info("Success to create " + profile + " from " + contactDTO);;

				return contactDTO;
			}
		}catch(Exception e) {
			String message = "Failed to create the profile from " + contactDTO;
			this.getLogger().error(message, e);
			throw new PalomaException(message);
		}

	}

	private Boolean profileAlreadyExists(ContactDTO contact) 
			throws PalomaPersistenceContextException {
		Boolean alreadyExists = Boolean.FALSE;
		try {
			alreadyExists = this
					.profileService.getRepository()
					.findByFirstNameAndLastName(contact.getFirstName(), 
							contact.getLastName()) != null;
			return alreadyExists;
		}catch(Exception e){
			String message = "Failed to check if " + contact
					+ " already exists";
			this.getLogger().error(message, e);
			throw new PalomaPersistenceContextException(message);
		}
	}

	/**
	 * Update the data matching the contact DTO given in parameter
	 * @param The contact DTO
	 * @return The contact DTO
	 * @throws PalomaException
	 */
	@RequestMapping(method=RequestMethod.PUT)
	@ResponseBody public  ContactDTO update(@RequestBody ContactDTO contactDTO) 
			throws PalomaException{
		Profile profile = null;
		Contact contact = null;
		try{
			contact = this.contactService.find(contactDTO.getId());
			profile = this.profileService.getRepository().findByContact(contact);
			profile.setFirstName(contactDTO.getFirstName());
			profile.setLastName(contactDTO.getLastName());
			profile.setBirthDate(contactDTO.getBirthDate());
			//Contact part
			contact.setPhoneNumber(contactDTO.getPhoneNumber());
			contact.setAddress(contactDTO.getAddress());
			contact.setEmail(contactDTO.getEmail());
			contact.setZip(contactDTO.getZip());
			contact.setProEmail(contactDTO.getProEmail());
			contact.setCity(contactDTO.getCity());
			if(contactDTO.getCountry() != null 
					&& !contactDTO.getCountry().isEmpty()) {
				Country country = this
						.contactService
						.findCountry(contactDTO.getCountry());
				if(country == null){
					country = this
							.contactService
							.createCountry(contactDTO.getCountry());
				}
				contact
				.setCountry(country);
			}
			contact = this.contactService.update(contact);
			this.getLogger().debug("Success to update " + contact);
			profile.setContact(contact);
			profile = this.profileService.update(profile);
			this.getLogger().info("Success to create " + profile);
			this.getLogger().debug("Success to update " + profile);
			return contactDTO;
		}catch(Exception e){
			String message = this + " fail to update the profile " 
					+ profile + " given in parameter";
			this.getLogger().error(message, e);
			throw new PalomaException(message);
		}
	}

	/**
	 * Set the profile as deleted
	 * @param profile The profile to set
	 * @throws PalomaException
	 */
	@RequestMapping(method=RequestMethod.DELETE)
	public void delete(@RequestBody Profile profile)
			throws PalomaException{
		try{
			profile.setIsDeleted(Boolean.TRUE);
			this.profileService.update(profile);
			this.getLogger().info("Success to set " + profile + " as deleted");
		}catch(Exception e){
			String message = "Failed to set " + profile + " as deleted";
			this.getLogger().error(message, e);
			throw new PalomaException(message);
		}
	}

	/**
	 * @return The logger
	 */
	private Logger getLogger() {
		return this.logService.getLogger();
	}
}
