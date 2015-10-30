package com.paloit.paloma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.paloit.paloma.domain.Profile;

/**
 * ProfileRepository.
 * @author DTRANG
 *
 */
public interface ProfileRepository  extends JpaRepository<Profile, Long>,JpaSpecificationExecutor<Profile>{

}
