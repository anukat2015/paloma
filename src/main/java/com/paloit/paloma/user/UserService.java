package com.paloit.paloma.user;

import com.paloit.paloma.BusinessEntityService;
import com.paloit.paloma.domain.User;
import com.paloit.paloma.dto.GoogleUserDTO;
import com.paloit.paloma.dto.UserDTO;
import com.paloit.paloma.utils.exception.PalomaPersistenceContextException;

/**
 * 
 * @author SLOPESNEVES
 * Service used to manage user
 *
 */
public interface UserService extends BusinessEntityService<User, Long> {
	/**
	 * Find in the persistence context
	 * the user matching the user DTO
	 * email and password given in parameter
	 * @param userDTO The user DTO
	 * @return The user
	 */
	public User findByEmailAndPassword(UserDTO userDTO) 
			throws PalomaPersistenceContextException;
	
	/**
	 * Find the user matching the google user given in parameter
	 * @param googleUser The Google id
	 * @return The user
	 * @throws PalomaPersistenceContextException
	 */
	public User find(GoogleUserDTO googleUser) 
			throws PalomaPersistenceContextException;
}
