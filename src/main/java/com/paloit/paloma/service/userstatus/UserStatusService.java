package com.paloit.paloma.service.userstatus;

import java.util.List;

import com.paloit.paloma.domain.UserStatus;

/**
 * UserStatus service.
 * @author DTRANG
 *
 */
public interface UserStatusService {

	/**
	 * Create a UserStatus with this parameter.
	 * @param title
	 */
	public void create(String title);

	/**
	 * Update a UserStatus with this parameter.
	 * @param id
	 * @param title
	 */
	public void update(Long id, String title);
	
	/**
	 * Find if the UserStatus already exists.
	 * @param title
	 * @return
	 */
	public UserStatus findUserStatus(String title);
	
	/**
	 * Retrieve every records.
	 * @return
	 */
	public List<UserStatus> findAll();
}
