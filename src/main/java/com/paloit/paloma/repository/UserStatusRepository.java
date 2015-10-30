package com.paloit.paloma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.paloit.paloma.domain.UserStatus;

/**
 * UserStatus repository.
 * @author DTRANG
 *
 */
public interface UserStatusRepository extends JpaRepository<UserStatus, Long>,JpaSpecificationExecutor<UserStatus>{

}
