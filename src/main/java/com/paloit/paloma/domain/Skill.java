package com.paloit.paloma.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Skill of profile.
 * Created by Yu on 27/10/2015.
 */
@Entity
@Table(name="SKILL")
public class Skill {
	
	/**
     * Sequence name.
     */
    private static final String SEQUENCENAME = "SEQUENCE_SKILL";
  
	/**
	 * Skill id.
	 */
    @Id
    @SequenceGenerator(name = SEQUENCENAME, sequenceName = SEQUENCENAME, initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCENAME)
    @Column(name = "ID_SKILL", length = 10)
    private Long id;
    
    /**
     * Title of the skill.
     */
    @Column(name = "TITLE", length = 50)
    private String title;
    
    /**
     * List of profile who have the skill.
     */
    @ManyToMany(mappedBy="skills")
    private List<Profile> profiles;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the profiles
	 */
	public List<Profile> getProfiles() {
		return profiles;
	}

	/**
	 * @param profiles the profiles to set
	 */
	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}

	

    
}
