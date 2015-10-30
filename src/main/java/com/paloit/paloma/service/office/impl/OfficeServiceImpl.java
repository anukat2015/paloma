package com.paloit.paloma.service.office.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paloit.paloma.domain.Office;
import com.paloit.paloma.repository.OfficeRepository;
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
		

	

	

}
