package com.paloit.paloma.domain;



import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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
	 * Profile language.
	 */
	@EmbeddedId
	private ProfileLanguageId profileLanguageId;
	
	/**
	 * Level.
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "LEVEL")
    private LanguageLevel level;
	

	/**
	 * @return the profileLanguageId
	 */
	public ProfileLanguageId getProfileLanguageId() {
		return profileLanguageId;
	}

	/**
	 * @param profileLanguageId the profileLanguageId to set
	 */
	public void setProfileLanguageId(ProfileLanguageId profileLanguageId) {
		this.profileLanguageId = profileLanguageId;
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
