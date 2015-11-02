package com.paloit.paloma.service.country.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paloit.paloma.domain.Country;
import com.paloit.paloma.repository.CountryRepository;
import com.paloit.paloma.rest.ProfileResource;
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
	 * Log.
	 */
	private static final Logger logger = LogManager.getLogger(CountryServiceImpl.class);
	
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

	public List<Country> findAll() {
		List<Country> countries = countryRepository.findAll();
		return countries;
	}

	public void delete(Long id) {
		countryRepository.delete(id);
	}

}
