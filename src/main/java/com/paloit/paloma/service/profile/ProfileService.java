package com.paloit.paloma.service.profile;

import java.sql.Date;
import java.util.List;

import com.paloit.paloma.domain.Contact;
import com.paloit.paloma.domain.Profile;
import com.paloit.paloma.dto.ContactDTO;

/**
 * Service profile.
 * @author DTRANG
 *
 */
public interface ProfileService {
	
	/**
	 * Create a profilein a contact.
	 * @param id
	 * @return
	 */
	String createContact(ContactDTO contactDTO);
	
	/**
	 * Update a profile in a contact.
	 * @param id
	 * @return
	 */
	String updateContact(ContactDTO contactDTO);
	
	/**
	 * Find a profile with the same name and lastname.
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	Profile findByFirstNameAndLastName(String firstName, String lastName);

	/**
	 * Find contacts for one profile.
	 * @param id
	 * @return
	 */
	List<Contact> findContactsByProfileId(Long id);
	
	/**
	 * 
	 * @param keys
	 * @param contractType
	 * @param zip
	 * @param expYear
	 * @param order
	 * @return
	 */
	//List<Profile> search(String keys, String contractType, String zip, String expYear, Date availability, String office, String mobility, String status, String recruitmentStatus,  String order);
}
