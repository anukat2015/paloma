package com.paloit.paloma.controller;

import com.paloit.paloma.dto.ContactDTO;
import com.paloit.paloma.dto.RecruitmentDTO;
import com.paloit.paloma.dto.SkillDTO;
import com.paloit.paloma.domain.Skill;
import com.paloit.paloma.dto.CareerDTO;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing Profile.
 */
@RestController
@RequestMapping("/profile")
public class ProfileResource {
	
	/**
     *  method to create a profile.
     */
    @RequestMapping(value = "/createProfile",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createProfile(@RequestBody ContactDTO contact){
        
    }

    /**
     *  method to save screen contact identified by id.
     */
    @RequestMapping(value = "/saveContact/{id}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveContact(@PathVariable Long id, @RequestBody ContactDTO contactDTO){
        
    }

    /**
     *  method to save screen skill of a profile identified by id.
     */
    @RequestMapping(value = "/saveSkill/{id}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveSkill(@PathVariable Long id, @RequestBody SkillDTO skillDTO){
        
        
    }

    /**
     *  method to save screen career of a profile identified by id
     */
    @RequestMapping(value = "/saveCareer/{id}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveCareer(@PathVariable Long id, @RequestBody CareerDTO staff){
        
    }

    /**
     *  method to save screen recruitment of a profile identified by id
     */
    @RequestMapping(value = "/saveRecruitment/{id}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveRecruitment(@PathVariable Long id, @RequestBody RecruitmentDTO recruitment){
        
    }
}
