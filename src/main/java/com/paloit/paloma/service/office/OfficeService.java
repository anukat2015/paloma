package com.paloit.paloma.service.office;

import java.util.List;

import com.paloit.paloma.domain.Office;

/**
 * Office service.
 * @author DTRANG
 *
 */
public interface OfficeService {

	/**
	 * Create a office with this parameter.
	 * @param title
	 */
	public void create(String title);

	/**
	 * Update a office with this parameter.
	 * @param id
	 * @param title
	 */
	public void update(Long id, String title);
	
	/**
	 * Find if the office already exists.
	 * @param title
	 * @return
	 */
	public Office findOffice(String title);
	
	/**
	 * Retrieve every records.
	 * @return
	 */
	public List<Office> findAll();
}
