package com.paloit.paloma.service.country;

import com.paloit.paloma.domain.Country;

/**
 * Country service.
 * @author DTRANG
 *
 */
public interface CountryService {

	/**
	 * Create a country with this parameter.
	 * @param title
	 */
	public void create(String title);

	/**
	 * Update a country with this parameter.
	 * @param id
	 * @param title
	 */
	public void update(Long id, String title);
	
	/**
	 * Find if the country already exists.
	 * @param title
	 * @return
	 */
	public Country findCountry(String title);
	
}
