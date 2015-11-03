package com.paloit.paloma.service.profile.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paloit.paloma.domain.Contact;
import com.paloit.paloma.domain.Profile;
import com.paloit.paloma.repository.ContactRepository;
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
	
	public List<Contact> findContactsByProfileId(Long id){
		
		Profile profile = profileRepository.findById(id);
		List<Contact> contacts = profile.getContact();
		
		return contacts;
	}
}
