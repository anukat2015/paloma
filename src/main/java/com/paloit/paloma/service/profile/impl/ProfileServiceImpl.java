package com.paloit.paloma.service.profile.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.paloit.paloma.domain.Contact;
import com.paloit.paloma.domain.Country;
import com.paloit.paloma.domain.Profile;
import com.paloit.paloma.dto.ContactDTO;
import com.paloit.paloma.dto.SkillDTO;
import com.paloit.paloma.repository.ContactRepository;
import com.paloit.paloma.repository.CountryRepository;
import com.paloit.paloma.repository.ProfileRepository;
import com.paloit.paloma.service.profile.ProfileService;

/**
 * Implemented profile service.
 * @author DTRANG
 *
 */
@Service("ProfileService")
@Transactional
public class ProfileServiceImpl implements ProfileService{

	/**
	 * Profile repository.
	 */
	@Autowired
	ProfileRepository profileRepository;
	
	/**
	 * Contact repository.
	 */
	@Autowired
	ContactRepository contactRepository;
	
	/**
	 * Country repository.
	 */
	@Autowired
	CountryRepository countryRepository;
	
	public Contact findContactsByProfileId(Long id){
		
		Profile profile = profileRepository.findById(id);
		Contact contact = profile.getContact();
		
		return contact;
	}
/*
	public List<Profile> search(final String keys, final String contractType, final String zip, final String expYear, final Date availability,
			final String office, final String mobility, final String status, final String recruitmentStatus, String order) {
		
		Specification<Profile> spec = new Specification<Profile>(){

			public Predicate toPredicate(Root<Profile> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
				
				if (!StringUtils.isEmpty(keys)){
					String []words = keys.split(" ");
					
				}
				if (!StringUtils.isEmpty(zip)){
					predicateList.add(cb.and(cb.equal(root.get("zip"),zip)));
				}
				
				return null;
			}
			
		};
		return null;
	}
*/
	public String createContact(ContactDTO contactDTO) {
		
		if (!StringUtils.isEmpty(contactDTO.getFirstName()) && !StringUtils.isEmpty(contactDTO.getLastName())){
			if (null != findByFirstNameAndLastName(contactDTO.getFirstName(),contactDTO.getLastName())){
				Contact contact = new Contact();
				contact.setAddress(contactDTO.getAddress());
				contact.setCity(contactDTO.getCity());
				contact.setEmail(contactDTO.getEmail());
				contact.setPhoneNumber(contactDTO.getPhoneNumber());
				contact.setZip(contactDTO.getZip());
				Country country = countryRepository.findByTitle(contactDTO.getCountry());
				if (country != null){
					contact.setCountry(country);
				}
				Profile profile = new Profile();
				profile.setContact(contact);
				profile.setFirstName(contactDTO.getFirstName());
				profile.setLastName(contactDTO.getLastName());
				profile.setBirthDate(contactDTO.getBirthDate());
				
				profile = profileRepository.saveAndFlush(profile);
				
				return Long.toString(profile.getId());
			}
		}
		return null;
	}
	
	
	public String updateContact(ContactDTO contactDTO) {
		
		if (!StringUtils.isEmpty(contactDTO.getFirstName()) && !StringUtils.isEmpty(contactDTO.getLastName())){
		    Profile profile = findByFirstNameAndLastName(contactDTO.getFirstName(),contactDTO.getLastName());
			if (null != profile){
			    Contact contact = new Contact();
				contact.setAddress(contactDTO.getAddress());
				contact.setCity(contactDTO.getCity());
				contact.setEmail(contactDTO.getEmail());
				contact.setPhoneNumber(contactDTO.getPhoneNumber());
				contact.setZip(contactDTO.getZip());
				Country country = countryRepository.findByTitle(contactDTO.getCountry());
				if (country != null){
					contact.setCountry(country);
				}				
				profile.setContact(contact);
				profile.setFirstName(contactDTO.getFirstName());
				profile.setLastName(contactDTO.getLastName());
				profile.setBirthDate(contactDTO.getBirthDate());
				
				profile = profileRepository.saveAndFlush(profile);
				
				return Long.toString(profile.getId());
			}
			
		}
		return null;
	}

	public Profile findByFirstNameAndLastName(String firstName, String lastName) {
		
		Profile profile = profileRepository.findByFirstNameAndLastName(firstName, lastName);
		return profile;
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
	
	
}
