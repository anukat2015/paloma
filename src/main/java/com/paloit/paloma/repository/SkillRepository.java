package com.paloit.paloma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.paloit.paloma.domain.Skill;

/**
 * Skill repository.
 * @author DTRANG
 *
 */
public interface SkillRepository extends JpaRepository<Skill, Long>,JpaSpecificationExecutor<Skill>{

}
