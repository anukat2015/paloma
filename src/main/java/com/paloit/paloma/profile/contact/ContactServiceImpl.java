/**
 * 
 */
package com.paloit.paloma.profile.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paloit.paloma.BusinessEntityServiceImpl;
import com.paloit.paloma.domain.Contact;
import com.paloit.paloma.domain.Country;
import com.paloit.paloma.dto.ContactDTO;
import com.paloit.paloma.profile.CountryRepository;
import com.paloit.paloma.utils.exception.PalomaException;

/**
 * @author SLOPESNEVES
 * The service to used to manage contact
 *
 */
@Service
@Transactional
public class ContactServiceImpl extends BusinessEntityServiceImpl<Contact, Long> implements ContactService {

	/**
	 * The repository used to manage 
	 * contact in the persistence context
	 */
	private ContactRepository contactRepository;
	
	/**
	 * The country repository
	 */
	private CountryRepository countryRepository;
	
	/**
	 * Create the contact matching the contact DTO
	 * given in parameter
	 * @param contactDTO The contact
	 * @return The contact
	 * @throws PalomaException
	 */
	public Contact create(ContactDTO contactDTO) throws PalomaException {
		Contact contact = null;
		
		try{
			contact = this.create();
			contact.setPhoneNumber(contactDTO.getPhoneNumber());
			contact.setAddress(contactDTO.getAddress());
			contact.setEmail(contactDTO.getEmail());
			contact.setZip(contactDTO.getZip());
			contact.setProEmail(contactDTO.getProEmail());
			contact.setCity(contactDTO.getCity());
			if(contactDTO.getCountry() != null 
					&& !contactDTO.getCountry().isEmpty()) {
				Country country = this.countryRepository.findByTitleIgnoreCase(contactDTO.getCountry());
				if(country == null){
					country = new Country();
					country.setTitle(contactDTO.getCountry());
					country = this.countryRepository.save(country);
				}
				contact.setCountry(country);
			}
			contact = this.update(contact);
			//TODO Add info log
			return contact;
		}catch(Exception e){
			String message = this + " failed to create contact from " + contactDTO;
			//TODO Add error log
			throw new PalomaException(message);
		}
	}
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
	public JpaRepository<Contact, Long> getRepository() {
		return this.contactRepository;
	}

}
