package com.paloit.paloma.service.office.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paloit.paloma.domain.Office;
import com.paloit.paloma.repository.OfficeRepository;
import com.paloit.paloma.service.language.impl.LanguageServiceImpl;
import com.paloit.paloma.service.office.OfficeService;

/**
 * Office implemented service.
 * @author DTRANG
 *
 */
@Service("OfficeService")
@Transactional
public class OfficeServiceImpl implements OfficeService{

	/**
	 * Log.
	 */
	private static final Logger logger = LogManager.getLogger(OfficeServiceImpl.class);
	
	/**
	 * Office repository.
	 */
	@Autowired
	OfficeRepository officeRepository;
	
	public void create(String title) {
		
		Office office = new Office();
		if (null != findOffice(title)){
			office.setTitle(title);
			officeRepository.saveAndFlush(office);
		}
	}

	public void update(Long id, String title) {
		
		Office office = officeRepository.findOne(id);		
		if (null != findOffice(title)){
			office.setTitle(title);
			officeRepository.saveAndFlush(office);
		}
		
	}

	public Office findOffice(String title) {
		
		Office office = officeRepository.findByTitle(title);				
		return office;
		
	}

	public List<Office> findAll() {
		
		List<Office> offices = officeRepository.findAll();
		return offices;
	}

	public void delete(Long id) {
		officeRepository.delete(id);
	}
		

	

	

}
