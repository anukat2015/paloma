package com.paloit.paloma.profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.paloit.paloma.domain.Source;

/**
 * Source repository.
 * @author DTRANG
 *
 */
public interface SourceRepository extends JpaRepository<Source, Long>,JpaSpecificationExecutor<Source>{

	/**
	 * Find source by title.
	 * @param title
	 * @return
	 */
	Source findByTitle(String title);

}
