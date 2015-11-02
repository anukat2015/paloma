package com.paloit.paloma.service.userstatus.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paloit.paloma.domain.UserStatus;
import com.paloit.paloma.repository.UserStatusRepository;
import com.paloit.paloma.service.user.impl.UserServiceImpl;
import com.paloit.paloma.service.userstatus.UserStatusService;

/**
 * UserStatus implemented service.
 * @author DTRANG
 *
 */
@Service("UserStatusService")
@Transactional
public class UserStatusServiceImpl implements UserStatusService{

	/**
	 * Log.
	 */
	private static final Logger logger = LogManager.getLogger(UserStatusServiceImpl.class);
	
	/**
	 * UserStatus repository.
	 */
	@Autowired
	UserStatusRepository userStatusRepository;
	
	public void create(String title) {
		
		UserStatus userStatus = new UserStatus();
		if (null != findUserStatus(title)){
			userStatus.setTitle(title);
			userStatusRepository.saveAndFlush(userStatus);
		}
	}

	public void update(Long id, String title) {
		
		UserStatus userStatus = userStatusRepository.findOne(id);		
		if (null != findUserStatus(title)){
			userStatus.setTitle(title);
			userStatusRepository.saveAndFlush(userStatus);
		}
		
	}

	public UserStatus findUserStatus(String title) {	
		
		UserStatus userStatus = userStatusRepository.findByTitle(title);	
		return userStatus;
	}

	public List<UserStatus> findAll() {
		List<UserStatus> userStatus = userStatusRepository.findAll();
		return userStatus;
	}

}
