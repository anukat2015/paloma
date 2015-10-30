package com.paloit.paloma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.paloit.paloma.domain.Contract;

/**
 * Contract Repository.
 * @author DTRANG
 *
 */
public interface ContractRepository extends JpaRepository<Contract, Long>,JpaSpecificationExecutor<Contract>{

}
