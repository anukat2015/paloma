package com.paloit.paloma.profile;

import com.paloit.paloma.BusinessEntityService;
import com.paloit.paloma.domain.Contact;
import com.paloit.paloma.domain.Profile;
import com.paloit.paloma.dto.ContactDTO;
import com.paloit.paloma.dto.SkillDTO;
import com.paloit.paloma.utils.exception.PalomaException;

/**
 * Service profile.
 * @author DTRANG
 *
 */
public interface ProfileService extends BusinessEntityService<Profile, Long> {
	
	/**
	 * Create a new profile from the contact given in parameter
	 * @param contact The contact
	 * @return The new profile
	 * @throws PalomaException
	 */
	public Profile create(ContactDTO contact) throws PalomaException;
	
	
	/**
	 * Update the skills.
	 * @param id
	 * @param skillDTO
	 * @return
	 */
	Profile updateSkill(Long id, SkillDTO skillDTO);

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
