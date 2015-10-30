package com.paloit.paloma.service.language.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paloit.paloma.domain.Language;
import com.paloit.paloma.repository.LanguageRepository;
import com.paloit.paloma.service.language.LanguageService;

/**
 * Language implemented service.
 * @author DTRANG
 *
 */
@Service("LanguageService")
@Transactional
public class LanguageServiceImpl implements LanguageService{

	/**
	 * Language repository.
	 */
	@Autowired
	LanguageRepository languageRepository;
	
	public void create(String title) {
		
		Language language = new Language();
		if (null != findLanguage(title)){
			language.setTitle(title);
			languageRepository.saveAndFlush(language);
		}
	}

	public void update(Long id, String title) {
		
		Language language = languageRepository.findOne(id);		
		if (null != findLanguage(title)){
			language.setTitle(title);
			languageRepository.saveAndFlush(language);
		}
		
	}

	public Language findLanguage(String title) {
		
		Language language = languageRepository.findByTitle(title);		
		return language;
		
	}

	public List<Language> findAll() {
		List<Language> languages = languageRepository.findAll();
		return languages;
	}

	public void delete(Long id) {
		languageRepository.delete(id);		
	}
		

	

	

}
