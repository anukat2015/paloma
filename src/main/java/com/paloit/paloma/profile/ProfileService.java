package com.paloit.paloma.profile;

import com.paloit.paloma.BusinessEntityService;
import com.paloit.paloma.domain.Contact;
import com.paloit.paloma.domain.Profile;
import com.paloit.paloma.dto.ContactDTO;
import com.paloit.paloma.dto.SkillDTO;

/**
 * Service profile.
 * @author DTRANG
 *
 */
public interface ProfileService extends BusinessEntityService<Profile, Long> {
	
	/**
	 * Create a profile in a contact.
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
	 * Update the skills.
	 * @param id
	 * @param skillDTO
	 * @return
	 */
	Profile updateSkill(Long id, SkillDTO skillDTO);
	
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
	Contact findContactsByProfileId(Long id);
	
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
