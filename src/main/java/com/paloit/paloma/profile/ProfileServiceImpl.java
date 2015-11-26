package com.paloit.paloma.profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paloit.paloma.BusinessEntityServiceImpl;
import com.paloit.paloma.domain.Contact;
import com.paloit.paloma.domain.Profile;
import com.paloit.paloma.dto.SkillDTO;

/**
 * Implemented profile service.
 * @author DTRANG
 *
 */
@Service("ProfileService")
@Transactional
public class ProfileServiceImpl extends BusinessEntityServiceImpl<Profile, Long, ProfileRepository> implements ProfileService{

	/**
	 * Profile repository.
	 */
	@Autowired
	private ProfileRepository profileRepository;
	
	
	public Contact findContactsByProfileId(Long id){

		Profile profile = profileRepository.findById(id);
		Contact contact = profile.getContact();

		return contact;
	}
	
	public Profile updateSkill(Long id, SkillDTO skillDTO) {
		Profile profile  = profileRepository.findById(id);
		if (null != profile){
			profile.setTitle(skillDTO.getTitle());
			profile.setDiploma(skillDTO.getDiploma());
			profile.setDiplomaDate(skillDTO.getDiplomaDate());
			profile.setIdDriveDoc(skillDTO.getIdDriveDoc());
			profile.setSkills(skillDTO.getSkills());
			profile.setProfileLanguages(skillDTO.getProfileLanguages());

			profileRepository.saveAndFlush(profile);
		}
		return null;
	}

	/**
	 * @return The Profile class
	 */
	@Override
	public Class<Profile> getEntityClass() {
		return Profile.class;
	}

	/**
	 * @return The profile repository
	 */
	@Override
	public ProfileRepository getRepository() {
		return this.profileRepository;
	}
	
	protected List<Profile> findAllQuery() {
		return this.getRepository().findByIsDeletedFalseOrIsDeletedNullOrderByFirstName();
	}


}
