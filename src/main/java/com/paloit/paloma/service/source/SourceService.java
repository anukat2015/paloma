package com.paloit.paloma.service.source;

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
	
}
