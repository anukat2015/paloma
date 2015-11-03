package com.paloit.paloma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.paloit.paloma.domain.User;

/**
 * User repository.
 * @author DTRANG
 *
 */
public interface UserRepository extends JpaRepository<User, Long>,JpaSpecificationExecutor<User>{

	/**
	 * Find if an user already exists by email.
	 * @param email
	 * @return
	 */
	User findByEmail(String email);
	
	/**
	 * For log in. Return the user corresponding to the email and password given.
	 */
	@Query("SELECT u FROM User u WHERE u.email=:email AND u.password=:password")
	User findByEmailAndPassword(String email, String password);
}
