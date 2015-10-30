package com.paloit.paloma.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Interview of the profile.
 * Created by Yu on 27/10/2015.
 */
@Entity
@Table(name="INTERVIEW")
public class Interview {
	/**
     * Sequence name.
     */
    private static final String SEQUENCENAME = "SEQUENCE_INTERVIEW";
  
	/**
	 * Interview id.
	 */
    @Id
    @SequenceGenerator(name = SEQUENCENAME, sequenceName = SEQUENCENAME, initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCENAME)
    @Column(name = "ID_INTERVIEW", length = 10)
	private Long id;
    
    /**
     * Date of the interview.
     */
    @Column(name = "DATE")
    private Date date;
    
    /**
     * The responsible of the interview.
     */
    @ManyToOne
    @JoinColumn(name = "ID_USER")
    private User user;
    
    /**
     * Comment.
     */
    @Column(name = "COMMENT", length = 255)
    private String comment;
    
    @ManyToOne
    @JoinColumn(name="ID_PROFILE")
    private Profile profile;

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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
    
}
