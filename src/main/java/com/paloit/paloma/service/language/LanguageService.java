package com.paloit.paloma.service.language;

import com.paloit.paloma.domain.Language;

/**
 * Language service.
 * @author DTRANG
 *
 */
public interface LanguageService {

	/**
	 * Create a language with this parameter.
	 * @param title
	 */
	public void create(String title);

	/**
	 * Update a language with this parameter.
	 * @param id
	 * @param title
	 */
	public void update(Long id, String title);
	
	/**
	 * Find if the language already exists.
	 * @param title
	 * @return
	 */
	public Language findLanguage(String title);
	
}
