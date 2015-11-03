package com.paloit.paloma.service.user;

import com.paloit.paloma.domain.User;
import com.paloit.paloma.domain.UserStatus;
import com.paloit.paloma.dto.UserDTO;

public interface UserService {
	
	/**
	 * Create new user.
	 * @param email
	 * @param firstname
	 * @param lastname
	 * @param password
	 */
	public void create(String email, String firstname, String lastname, String password, UserStatus userStatus);

	
	public User findByEmailAndPassword(UserDTO userDTO);
}
