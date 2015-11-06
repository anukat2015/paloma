package com.paloit.paloma.user;

import java.util.Calendar;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paloit.paloma.domain.User;
import com.paloit.paloma.dto.UserDTO;
import com.paloit.paloma.dto.UserGoogleDTO;
import com.paloit.paloma.utils.PalomaConstants;
import com.paloit.paloma.utils.exception.PaloITDomainRestrictionException;
import com.paloit.paloma.utils.exception.PalomaException;
import com.paloit.paloma.utils.exception.PalomaPersistenceContextException;

/**
 * Implemented user service.
 * @author DTRANG
 *
 */
@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService{


	/**
	 * User repository.
	 */
	@Autowired
	private UserRepository userRepository;

	/**
	 * The current user
	 */
	private User currentUser;

	public User authentication(UserGoogleDTO googleUser) 
			throws PalomaException {

		this.checkPaloITDomain(googleUser);

		User user = userRepository.findByEmail(googleUser.getEmail());

		if(user == null){
			this.create(googleUser);
		}

		return user;
	}

	private void checkPaloITDomain(UserGoogleDTO googleUser)
			throws PaloITDomainRestrictionException {
		try{
			if(!PalomaConstants.PALO_IT_DOMAIN.equals(googleUser.getDomain())){
				throw new PaloITDomainRestrictionException("The user " + googleUser + " is not allowed to log in this application");
			}
		}catch(PaloITDomainRestrictionException e){
			//TODO Add log
			throw e;
		}
	}



	public User create(UserGoogleDTO googleUser) throws PalomaPersistenceContextException {
		User user = new User();
		user.setEmail(googleUser.getEmail());
		user.setFirstName(googleUser.getFirstName());
		user.setLastName(googleUser.getFamilyName());
		user.setIsBanned(false);
		user.setCreatedDate(Calendar.getInstance().getTime());
		try{
			user = userRepository.saveAndFlush(user);
		}catch(HibernateException e){
			//TODO Add logger
			throw new PalomaPersistenceContextException(e);
		}
		return user;
	}



	public User findByEmailAndPassword(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}


}
