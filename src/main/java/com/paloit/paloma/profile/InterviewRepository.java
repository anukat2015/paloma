package com.paloit.paloma.profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.paloit.paloma.domain.Interview;

/**
 * Interview repository.
 * @author DTRANG
 *
 */
public interface InterviewRepository extends JpaRepository<Interview, Long>,JpaSpecificationExecutor<Interview>{

}
