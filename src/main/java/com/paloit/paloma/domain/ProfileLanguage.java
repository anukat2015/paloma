package com.paloit.paloma.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.paloit.paloma.utils.enums.LanguageLevel;

/**
 * Association between profile and Language.
 * Created by Yu on 27/10/2015.
 */
@Entity
@Table(name="PROFILE_LANGUAGE")
public class ProfileLanguage extends BusinessEntity<Long> {
	
	/**
	 * The generated serial UID
	 */
	private static final long serialVersionUID = -8626523516824252891L;

	/**
     * Sequence name.
     */
    private static final String SEQUENCENAME = "SEQUENCE_PROFILE_LANGUAGE";
	
	/**
	 * Language id.
	 */
    @Id
    @SequenceGenerator(name = SEQUENCENAME, sequenceName = SEQUENCENAME, initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCENAME)
    @Column(name = "ID_LANGUAGE", length = 10)
	private Long id;
    
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
	 * Level.
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "LEVEL")
    private LanguageLevel level;
	

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

	@Override
	Long getId() {
		return null;
	}

	@Override
	void setId(Long id) {
		
	}

    
    
}
