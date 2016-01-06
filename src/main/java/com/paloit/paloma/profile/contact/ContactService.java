package com.paloit.paloma.profile.contact;

import com.paloit.paloma.BusinessEntityService;
import com.paloit.paloma.domain.Contact;
import com.paloit.paloma.domain.Country;
import com.paloit.paloma.utils.exception.PalomaPersistenceContextException;

/**
 * 
 * @author SLOPESNEVES
 *
 */
public interface ContactService extends BusinessEntityService<Contact, Long, ContactRepository> {
	/**
	 * Find the country matching the country title given in parameter
	 * @param countryTitle The country title
	 * @return The country
	 * @throws PalomaPersistenceContextException
	 */
	Country findCountry(String countryTitle) throws PalomaPersistenceContextException;
	
	/**
	 * Create the country with the country title given in parameter
	 * @return The created country
	 * @throws PalomaPersistenceContextException
	 */
	Country createCountry(String countryTitle) throws PalomaPersistenceContextException;
}
