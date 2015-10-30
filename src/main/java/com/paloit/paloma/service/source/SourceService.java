package com.paloit.paloma.service.source;

import java.util.List;

import com.paloit.paloma.domain.Source;

/**
 * Source service.
 * @author DTRANG
 *
 */
public interface SourceService {

	/**
	 * Create a Source with this parameter.
	 * @param title
	 */
	public void create(String title);

	/**
	 * Update a Source with this parameter.
	 * @param id
	 * @param title
	 */
	public void update(Long id, String title);
	
	/**
	 * Find if the Source already exists.
	 * @param title
	 * @return
	 */
	public Source findSource(String title);
	
	/**
	 * Retrieve every records.
	 * @return
	 */
	public List<Source> findAll();
	
	/**
	 * Remove every records corresponding to the parameter.
	 * @param id
	 */
	public void delete(Long id);
	
}	
