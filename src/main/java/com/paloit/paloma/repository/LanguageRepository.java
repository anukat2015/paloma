package com.paloit.paloma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.paloit.paloma.domain.Language;

/**
 * Language repository.
 * @author DTRANG
 *
 */
public interface LanguageRepository extends JpaRepository<Language, Long>,JpaSpecificationExecutor<Language>{

	/**
	 * Find language by title.
	 * @param title
	 * @return
	 */
	Language findByTitle(String title);

}
