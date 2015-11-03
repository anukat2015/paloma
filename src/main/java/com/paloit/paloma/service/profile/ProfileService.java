package com.paloit.paloma.service.profile;

import java.util.List;

import com.paloit.paloma.domain.Contact;

/**
 * Service profile.
 * @author DTRANG
 *
 */
public interface ProfileService {

	List<Contact> findContactsByProfileId(Long id);
}
