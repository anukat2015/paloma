package com.paloit.paloma.profile.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.paloit.paloma.domain.Contact;

/**
 * Contact repository. 
 * @author DTRANG
 *
 */
public interface ContactRepository extends JpaRepository<Contact, Long>,JpaSpecificationExecutor<Contact>{
	
}
