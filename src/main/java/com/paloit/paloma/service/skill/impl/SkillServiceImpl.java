package com.paloit.paloma.service.skill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paloit.paloma.domain.Skill;
import com.paloit.paloma.repository.SkillRepository;
import com.paloit.paloma.service.office.impl.OfficeServiceImpl;
import com.paloit.paloma.service.skill.SkillService;

/**
 * Skill implemented service.
 * @author DTRANG
 *
 */
@Service("SkillService")
@Transactional
public class SkillServiceImpl implements SkillService{

	
	
	/**
	 * Skill repository.
	 */
	@Autowired
	SkillRepository skillRepository;
	
	public void create(String title) {
		
		Skill skill = new Skill();
		if (null != findSkill(title)){
			skill.setTitle(title);
			skillRepository.saveAndFlush(skill);
		}
	}

	public void update(Long id, String title) {
		
		Skill skill = skillRepository.findOne(id);		
		if (null != findSkill(title)){
			skill.setTitle(title);
			skillRepository.saveAndFlush(skill);
		}
		
	}

	public Skill findSkill(String title) {	
		
		Skill skill = skillRepository.findByTitle(title);	
		return skill;
	}

	public List<Skill> findAll() {
		
		List<Skill> skills = skillRepository.findAll();
		return skills;
	}
		

	

	

}
