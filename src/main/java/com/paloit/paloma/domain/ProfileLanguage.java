package com.paloit.paloma.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.paloit.paloma.utils.enums.LanguageLevel;

/**
 * Association between profile and Language.
 * Created by Yu on 27/10/2015.
 */
@Entity
@Table(name="PROFILE_LANGUAGE")
public class ProfileLanguage {

	/**
	 * Profile.
	 */
	@ManyToOne
	@JoinColumn(name="ID_PROFILE")
    private Profile profile;
	
	/**
	 * Language.
	 */
	@ManyToOne
	@JoinColumn(name="ID_LANGUAGE")
    private Language language;
	
	/**
	 * Level.
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "LEVEL")
    private LanguageLevel level;
	/**
	 * @return the profile
	 */
	public Profile getProfile() {
		return profile;
	}
	/**
	 * @param profile the profile to set
	 */
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	/**
	 * @return the language
	 */
	public Language getLanguage() {
		return language;
	}
	/**
	 * @param language the language to set
	 */
	public void setLanguage(Language language) {
		this.language = language;
	}
	/**
	 * @return the level
	 */
	public LanguageLevel getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(LanguageLevel level) {
		this.level = level;
	}
    
    
}
