package com.paloit.paloma.profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.paloit.paloma.domain.Skill;

/**
 * Skill repository.
 * @author DTRANG
 *
 */
public interface SkillRepository extends JpaRepository<Skill, Long>,JpaSpecificationExecutor<Skill>{

	/**
	 * Find the skill by title.
	 * @param title
	 * @return
	 */
	 Skill findByTitle(String title);

}
