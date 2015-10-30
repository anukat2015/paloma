package com.paloit.paloma.service.country.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paloit.paloma.domain.Country;
import com.paloit.paloma.repository.CountryRepository;
import com.paloit.paloma.service.country.CountryService;

/**
 * Country implemented service.
 * @author DTRANG
 *
 */
@Service("CountryService")
@Transactional
public class CountryServiceImpl implements CountryService{

	/**
	 * Country repository.
	 */
	@Autowired
	CountryRepository countryRepository;
	
	public void create(String title) {
		
		Country country = new Country();
		if (null != findCountry(title)){
			country.setTitle(title);
			countryRepository.saveAndFlush(country);
		}
	}

	public void update(Long id, String title) {
		
		Country country = countryRepository.findOne(id);		
		if (null != findCountry(title)){
			country.setTitle(title);
			countryRepository.saveAndFlush(country);
		}
		
	}

	public Country findCountry(String title) {	
		Country country = countryRepository.findByTitle(title);		
		
		return country;
	}
		

	

	

}
