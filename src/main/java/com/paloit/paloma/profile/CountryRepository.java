package com.paloit.paloma.profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.paloit.paloma.domain.Country;

public interface CountryRepository extends JpaRepository<Country, Long>,JpaSpecificationExecutor<Country>{

	/**
	 * Find country by title.
	 * @param title
	 * @return
	 */
	Country findByTitleIgnoreCase(String title);

}
