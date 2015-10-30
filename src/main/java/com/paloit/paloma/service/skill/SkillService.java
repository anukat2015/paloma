package com.paloit.paloma.service.skill;

import java.util.List;

import com.paloit.paloma.domain.Skill;

/**
 * Skill service.
 * @author DTRANG
 *
 */
public interface SkillService {

	/**
	 * Create a skill with this parameter.
	 * @param title
	 */
	public void create(String title);

	/**
	 * Update a skill with this parameter.
	 * @param id
	 * @param title
	 */
	public void update(Long id, String title);
	
	/**
	 * Find if the skill already exists.
	 * @param title
	 * @return
	 */
	public Skill findSkill(String title);
	
	/**
	 * Retrieve every records.
	 * @return
	 */
	public List<Skill> findAll();
}
