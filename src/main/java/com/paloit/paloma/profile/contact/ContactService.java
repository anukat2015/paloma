package com.paloit.paloma.profile.contact;

import com.paloit.paloma.BusinessEntityService;
import com.paloit.paloma.domain.Contact;
import com.paloit.paloma.dto.ContactDTO;
import com.paloit.paloma.utils.exception.PalomaException;

public interface ContactService extends BusinessEntityService<Contact, Long> {
	/**
	 * Create the contact matching the contact DTO
	 * given in parameter
	 * @param contactDTO The contact
	 * @return The contact
	 * @throws PalomaException
	 */
	public Contact create(ContactDTO contactDTO) throws PalomaException;
}
