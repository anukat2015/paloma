/**
 * 
 */
package com.paloit.paloma.profile.contact;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paloit.paloma.BusinessEntityServiceImpl;
import com.paloit.paloma.domain.Contact;

/**
 * @author SLOPESNEVES
 * The service to used to manage contact
 *
 */
@Service
@Transactional
public class ContactServiceImpl extends BusinessEntityServiceImpl<Contact, Long, ContactRepository> implements ContactService {

	/**
	 * The repository used to manage 
	 * contact in the persistence context
	 */
	private ContactRepository contactRepository;	
	
	/**
	 * @return The Contact class
	 */
	@Override
	public Class<Contact> getEntityClass() {
		return Contact.class;
	}

	/**
	 * @return The contact repository
	 */
	@Override
	public ContactRepository getRepository() {
		return this.contactRepository;
	}

}
