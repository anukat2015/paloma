package com.paloit.paloma.profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.paloit.paloma.domain.Profile;

/**
 * ProfileRepository.
 * @author DTRANG
 *
 */
public interface ProfileRepository  extends JpaRepository<Profile, Long>,JpaSpecificationExecutor<Profile>{

	/**
	 * Find all contact from a profile by Id.
	 * @return
	 */
	@Query("SELECT p FROM Profile p JOIN FETCH p.contact WHERE p.id=:id")
	Profile findById(@Param("id")Long id);
	
	
	Profile findByFirstNameAndLastName(String firstName,String lastName);
}
