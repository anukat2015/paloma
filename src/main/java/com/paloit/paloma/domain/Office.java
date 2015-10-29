package com.paloit.paloma.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Office of Palo.
 * Created by Yu on 27/10/2015.
 */
@Entity
@Table(name="OFFICE")
public class Office {
	
	/**
     * Sequence name.
     */
    private static final String SEQUENCENAME = "SEQUENCE_OFFICE";
  
	/**
	 * Office id.
	 */
    @Id
    @SequenceGenerator(name = SEQUENCENAME, sequenceName = SEQUENCENAME, initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCENAME)
    @Column(name = "ID_OFFICE", length = 10)
	private Long id;
	
    /**
     * Title of the office.
     */
    @Column(name = "TITLE", length = 50)
	private String title;

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
	
	
}
