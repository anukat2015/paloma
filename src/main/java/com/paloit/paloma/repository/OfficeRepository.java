package com.paloit.paloma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.paloit.paloma.domain.Office;

/**
 * Office repository.
 * @author DTRANG
 *
 */
public interface OfficeRepository extends JpaRepository<Office, Long>,JpaSpecificationExecutor<Office>{

	/**
	 * Find office by title.
	 * @param title
	 * @return
	 */
	Office findByTitle(String title);

}
