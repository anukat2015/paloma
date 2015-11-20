package com.paloit.paloma.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

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
public class UserServiceImpl 
extends BusinessEntityServiceImpl<User, Long, UserRepository> implements UserService{


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
			String message = "Failed to find user by email and password "
					+ "from " + userDTO;
			this.getLogger().error(message, e);
			throw new PalomaPersistenceContextException(message);

		}

	}


	@Override
	public User find(GoogleUserDTO googleUser) 
			throws PalomaPersistenceContextException {
		try{
			return this.userRepository.findByGoogleId(googleUser.getId());
		}catch(DataAccessException e){
			String message = "Failed to find user matching " +
					"the Google ID : " + googleUser;
			this.getLogger().error(message, e);
			throw new PalomaPersistenceContextException(message);
		}

	}

	@Override
	public Class<User> getEntityClass() {
		return User.class;
	}


	@Override
	public UserRepository getRepository() {
		return this.userRepository;
	}


}
