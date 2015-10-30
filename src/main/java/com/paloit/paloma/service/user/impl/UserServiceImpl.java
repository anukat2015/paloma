package com.paloit.paloma.service.user.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;

import com.paloit.paloma.domain.User;
import com.paloit.paloma.domain.UserStatus;
import com.paloit.paloma.repository.UserRepository;
import com.paloit.paloma.service.user.UserService;

/**
 * Implemented user service.
 * @author DTRANG
 *
 */
public class UserServiceImpl implements UserService{

	/**
	 * User repository.
	 */
	@Autowired
	UserRepository userRepository;

	public void create(String email, String firstname, String lastname, String password, UserStatus userStatus) {
		if (null != userRepository.findByEmail(email)){
			User user = new User();
			user.setEmail(email);
			user.setFirstName(firstname);
			user.setLastName(lastname);
			user.setPassword(password);
			user.setIsBanned(false);
			user.setCreatedDate(Calendar.getInstance().getTime());
			user.setUserStatus(userStatus);
			userRepository.saveAndFlush(user);
		}
	}
	
	
}
