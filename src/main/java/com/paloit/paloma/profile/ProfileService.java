package com.paloit.paloma.profile;

import com.paloit.paloma.BusinessEntityService;
import com.paloit.paloma.domain.Contact;
import com.paloit.paloma.domain.Profile;
import com.paloit.paloma.dto.SkillDTO;

/**
 * Service profile.
 * @author DTRANG
 *
 */
public interface ProfileService extends BusinessEntityService<Profile, Long, ProfileRepository>  {	
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
