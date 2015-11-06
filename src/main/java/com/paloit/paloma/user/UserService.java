package com.paloit.paloma.user;

import com.paloit.paloma.domain.User;
import com.paloit.paloma.dto.UserDTO;
import com.paloit.paloma.dto.UserGoogleDTO;
import com.paloit.paloma.utils.exception.PalomaPersistenceContextException;

public interface UserService {
	
	/**
	 * Create new user.
	 * @param googleUser User authenticated from Google SSO
	 * @return The created user
	 * @throws PalomaPersistenceContextException 
	 */
	public User create(UserGoogleDTO googleUser) throws PalomaPersistenceContextException;

	
	public User findByEmailAndPassword(UserDTO userDTO);
}
