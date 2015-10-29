package com.paloit.paloma.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Language spoken by the profile.
 * Created by Yu on 27/10/2015.
 */
@Entity
@Table(name="LANGUAGE")
public class Language {

	/**
     * Sequence name.
     */
    private static final String SEQUENCENAME = "SEQUENCE_LANGUAGE";
  
	/**
	 * Language id.
	 */
    @Id
    @SequenceGenerator(name = SEQUENCENAME, sequenceName = SEQUENCENAME, initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCENAME)
    @Column(name = "ID_LANGUAGE", length = 10)
    private int id;
    
    /**
     * Title of the language.
     */
    @Column(name = "TITLE", length = 50)
    private String title;

    /**
     * List of profile.
     */
    @OneToMany(mappedBy="language")
    private List<ProfileLanguage> profileLanguages;
	
    /**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
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
	 * @return the profileLanguages
	 */
	public List<ProfileLanguage> getProfileLanguages() {
		return profileLanguages;
	}

	/**
	 * @param profileLanguages the profileLanguages to set
	 */
	public void setProfileLanguages(List<ProfileLanguage> profileLanguages) {
		this.profileLanguages = profileLanguages;
	}

   

}
