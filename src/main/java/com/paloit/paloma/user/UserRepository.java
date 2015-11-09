package com.paloit.paloma.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.paloit.paloma.domain.User;

/**
 * User repository.
 * @author DTRANG
 *
 */
public interface UserRepository extends Repository<User, Long>{

	/**
	 * Find the user matching the email given in parameter
	 * @param email The email
	 * @return The user
	 */
	User findByEmail(String email);
	
	/**
	 * Find the user matching the email and the password
	 * given in parameter
	 * @param email The email
	 * @param password The password
	 * @return The user
	 */
	@Query("SELECT u FROM User u WHERE u.email=:email AND u.password=:password")
	User findByEmailAndPassword(String email, String password);
	
	/**
	 * Find the user matching the google ID
	 * given in parameter
	 * @param googleId The google ID
	 * @return The user
	 */
	User findByGoogleId(String googleId);
}
