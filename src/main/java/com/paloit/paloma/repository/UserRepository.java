package com.paloit.paloma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.paloit.paloma.domain.User;

/**
 * User repository.
 * @author DTRANG
 *
 */
public interface UserRepository extends JpaRepository<User, Long>,JpaSpecificationExecutor<User>{

}
