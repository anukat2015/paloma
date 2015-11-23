package com.paloit.paloma.profile.contact;

import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
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
	@ResponseBody public ContactDTO create(@RequestBody ContactDTO contactDTO) 
			throws PalomaException{
		Profile profile = null;
		try{

			if (this.profileAlreadyExists(contactDTO)){
				String message = this + " there is already a "
						+ " profile matching " + contactDTO;
				this.getLogger().warn("Profile matching " + contactDTO + "already exists");
				throw new PalomaProfileAlreadyExistException(message);

			}else {
				profile = this.mapFromDTO(contactDTO);
				this.getLogger().info("Success to create " + profile 
						+ " from " + contactDTO);;

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

	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody public List<ContactDTO> findAll() 
			throws PalomaException {
		List<ContactDTO> contactsDTO = null;
		List<Profile> profiles = null;
		try {
			profiles = this.profileService.findAll();
			contactsDTO = new LinkedList<>();
			
			for(Profile profile : profiles) {
				ContactDTO contactDTO = this.mapToDTO(profile);
				contactsDTO.add(contactDTO);
			}

			return contactsDTO;
		}catch(Exception e) {
			String message = "Failed to find all " 
					+ ContactDTO.class.getSimpleName();
			this.getLogger().error(message, e);
			throw new PalomaException(message);
		}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ResponseBody public ContactDTO find(@PathVariable Long id) 
			throws PalomaException{
		Profile profile = null;
		Contact contact = null;
		ContactDTO contactDTO = null;
		try{
			contact = this.contactService.find(id);
			profile = this.profileService.getRepository().findByContact(contact);
			
			contactDTO = this.mapToDTO(profile);
			
			return contactDTO;
		}catch(Exception e){
			String message = "Failed to load " + Profile.class.getSimpleName() 
					+ " id " + id;
			this.getLogger().error(message, e);
			throw new PalomaException(message);
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
		try{
			profile = this.mapFromDTO(contactDTO);
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

	private Profile mapFromDTO(ContactDTO contactDTO) 
			throws PalomaException{
		Profile profile = null;
		Contact contact = null;
		try{
			if(contactDTO.getId() == null) {
				profile = this.profileService.create();
				profile.setContact(this.contactService.create());
				contact = profile.getContact();
			}else{
				contact = this.contactService.find(contactDTO.getId());
				profile = this.profileService.getRepository().findByContact(contact);
			}

			
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
			profile.setContact(contact);
			profile = this.profileService.update(profile);
			this.getLogger().debug("Success to map " + profile + " from "
					+ contactDTO);
			contactDTO.setId(profile.getContact().getId());
			return profile;
		}catch(Exception e){
			String message = "Failed to map profile from" + contactDTO;
			this.getLogger().error(message, e);
			throw new PalomaException(message);
		}
	}
	
	private ContactDTO mapToDTO(Profile profile) throws PalomaException {
		ContactDTO contactDTO = null;
		try {
			if(profile.getContact() == null) {
				this.getLogger().warn(profile + 
						" was persisted without " 
						+ Contact.class.getSimpleName());
				profile.setContact(this.contactService.create());
				profile = this.profileService.update(profile);
			}
			contactDTO = new ContactDTO();

			contactDTO.setFirstName(profile.getFirstName());
			contactDTO.setLastName(profile.getLastName());

			Contact contact = profile.getContact();
			contactDTO.setId(contact.getId());
			contactDTO.setAddress(contact.getAddress());
			contactDTO.setCity(contact.getCity());
			if(contact.getCountry() != null) {
				contactDTO.setCountry(contact.getCountry().getTitle());
			}
			contactDTO.setZip(contact.getZip());
			contactDTO.setPhoneNumber(contact.getPhoneNumber());
			contactDTO.setEmail(contact.getEmail());
			contactDTO.setProEmail(contact.getProEmail());
			this.getLogger().debug("Success to map " + contactDTO + 
					" from " + profile);
			return contactDTO;
		}catch (Exception e){
			String message = "Failed to map a " + ContactDTO.class.getSimpleName() + 
					" from " + profile;
			this.getLogger().error(message, e);
			throw new PalomaException(e);
		}
	}

	/**
	 * @return The logger
	 */
	private Logger getLogger() {
		return this.logService.getLogger();
	}
}
