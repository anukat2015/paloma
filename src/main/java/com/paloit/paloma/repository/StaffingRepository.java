package com.paloit.paloma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.paloit.paloma.domain.Staffing;

/**
 * Staffing repository.
 * @author DTRANG
 *
 */
public interface StaffingRepository extends JpaRepository<Staffing, Long>,JpaSpecificationExecutor<Staffing>{

}
