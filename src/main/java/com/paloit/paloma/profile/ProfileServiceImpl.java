package com.paloit.paloma.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paloit.paloma.BusinessEntityServiceImpl;
import com.paloit.paloma.domain.Contact;
import com.paloit.paloma.domain.Profile;
import com.paloit.paloma.dto.ContactDTO;
import com.paloit.paloma.dto.SkillDTO;
import com.paloit.paloma.profile.contact.ContactService;
import com.paloit.paloma.utils.exception.PalomaException;
import com.paloit.paloma.utils.exception.PalomaPersistenceContextException;
import com.paloit.paloma.utils.exception.PalomaProfileAlreadyExistException;

/**
 * Implemented profile service.
 * @author DTRANG
 *
 */
@Service("ProfileService")
@Transactional
public class ProfileServiceImpl extends BusinessEntityServiceImpl<Profile, Long> implements ProfileService{

	/**
	 * Profile repository.
	 */
	@Autowired
	private ProfileRepository profileRepository;

	/**
	 * The contact service
	 */
	private ContactService contactService;

	/**
	 * Create a new profile from the contact given in parameter
	 * @param contact The contact
	 * @return The new profile
	 * @throws PalomaException
	 */
	public Profile create(ContactDTO contact) throws PalomaException {
		Profile profile = null;
		try{
			
			if (this.profileAlreadyExists(contact)){
				String message = this + " there is already a "
						+ " profile matching " + contact;
				//TODO Adding warn log
				throw new PalomaProfileAlreadyExistException(message);
				
			}else {
				profile = this.create();

				profile.setFirstName(contact.getFirstName());
				profile.setLastName(contact.getLastName());
				profile.setBirthDate(contact.getBirthDate());
				//Contact part
				profile.setContact(this.contactService.create(contact));
				profile = this.update(profile);
				//TODO Add info logger
				return profile;
			}
			
		}catch(Exception e) {
			String message = this + 
					" failed to create the profile from " + contact;
			//TODO Add error log
			throw new PalomaException(message);
		}

	}
	
	private Boolean profileAlreadyExists(ContactDTO contact) 
			throws PalomaPersistenceContextException {
		Boolean alreadyExists = Boolean.FALSE;
		try {
			alreadyExists = this
			.profileRepository
			.findByFirstNameAndLastName(contact.getFirstName(), 
					contact.getLastName()) == null;
			return alreadyExists;
		}catch(Exception e){
			String message = this + " failed to check if " + contact
					+ " already exists";
			//TODO Add error log
			throw new PalomaPersistenceContextException(message);
		}
	}
	
	

	

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
	public JpaRepository<Profile, Long> getRepository() {
		return this.profileRepository;
	}


}
