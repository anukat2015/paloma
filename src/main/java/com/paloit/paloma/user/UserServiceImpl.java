package com.paloit.paloma.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paloit.paloma.BusinessEntityServiceImpl;
import com.paloit.paloma.domain.User;
import com.paloit.paloma.dto.GoogleUserDTO;
import com.paloit.paloma.dto.UserDTO;
import com.paloit.paloma.utils.exception.PalomaPersistenceContextException;

/**
 * Implemented user service.
 * @author DTRANG
 * @version 0.0.1
 *
 */
@Service("UserService")
@Transactional
public class UserServiceImpl 
extends BusinessEntityServiceImpl<User, Long> implements UserService{


	/**
	 * User repository.
	 */
	@Autowired
	private UserRepository userRepository;	


	/**
	 * Find the user matching the user DTO
	 * email and password given in parameter
	 * @param userDTO The user DTO
	 * @return The user
	 */
	public User findByEmailAndPassword(UserDTO userDTO) 
			throws PalomaPersistenceContextException  {
		try{
			return this.userRepository
					.findByEmailAndPassword(userDTO.getEmail(), 
							userDTO.getPassword());
		}catch(DataAccessException e){
			String message = this + " failed to find user by email and password "
					+ "from " + userDTO;
			//TODO Add logger error
			throw new PalomaPersistenceContextException(message);

		}

	}


	@Override
	public User find(GoogleUserDTO googleUser) 
			throws PalomaPersistenceContextException {
		try{
			return this.userRepository.findByGoogleId(googleUser.getId());
		}catch(DataAccessException e){
			String message = this + " failed to find user matching " +
					"the Google ID : " + googleUser;
			//TODO Add logger error
			throw new PalomaPersistenceContextException(message);
		}

	}

	@Override
	public Class<User> getEntityClass() {
		return User.class;
	}


	@Override
	protected String findAllQueryName() {
		return User.QUERY_NAME_FIND_ALL;
	}


}
