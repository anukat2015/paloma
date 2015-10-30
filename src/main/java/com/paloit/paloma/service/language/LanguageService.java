package com.paloit.paloma.service.language;

import java.util.List;

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
	
	/**
	 * Retrieve every records.
	 * @return
	 */
	public List<Language> findAll();
	
	/**
	 * Remove every records corresponding to the parameter.
	 * @param id
	 */
	public void delete(Long id);
}
