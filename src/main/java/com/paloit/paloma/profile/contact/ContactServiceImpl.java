/**
 * 
 */
package com.paloit.paloma.profile.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paloit.paloma.BusinessEntityServiceImpl;
import com.paloit.paloma.domain.Contact;
import com.paloit.paloma.domain.Country;
import com.paloit.paloma.profile.CountryRepository;
import com.paloit.paloma.utils.exception.PalomaPersistenceContextException;

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
	@Autowired
	private ContactRepository contactRepository;
	
	/**
	 * The repository used to manage
	 * country in the persistence context
	 */
	@Autowired
	private CountryRepository countryRepository;
	
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

	/**
	 * Find the country matching the country given in parameter
	 * @param countryTitle The country title
	 * @return The country
	 * @throws PalomaPersistenceContextException
	 */
	@Override
	public Country findCountry(String countryTitle) 
			throws PalomaPersistenceContextException {
		Country country = null;
		try {
			country = this.countryRepository.findByTitleIgnoreCase(countryTitle);
			return country;
		}catch(Exception e){
			String message = "Failed to find country matching " + countryTitle;
			this.getLogger().error(message, e);
			throw new PalomaPersistenceContextException(message);
		}
	}

	/**
	 * Create the country with the country title given in parameter
	 * @return The created country
	 * @throws PalomaPersistenceContextException
	 */
	@Override
	public Country createCountry(String countryTitle) 
			throws PalomaPersistenceContextException{
		Country country = null;
		try {
			country = new Country();
			country.setTitle(countryTitle);
			country = this.countryRepository.save(country);
			return country;
		}catch(Exception e){
			String message = "Failed to create country matching " + countryTitle;
			this.getLogger().error(message, e);
			throw new PalomaPersistenceContextException(message);
		}
	}
}
