package com.paloit.paloma.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class ProfileLanguageId implements Serializable{

	/**
	 * Generated id.
	 */
	private static final long serialVersionUID = -8587382523817350097L;

	/**
	 * Language.
	 */
	@ManyToOne
	private Language language;
	
	/**
	 * Profile.
	 */
	@ManyToOne
	private Profile profile;

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
	
	
}
