package com.paloit.paloma.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Represent the career of the profile with one client.
 * Created by Yu on 27/10/2015.
 */
@Entity
@Table(name="STAFFING")
public class Staffing {
	
	/**
     * Sequence name.
     */
    private static final String SEQUENCENAME = "SEQUENCE_STAFFING";
	/**
	 * The id.
	 */
    @Id
    @SequenceGenerator(name = SEQUENCENAME, sequenceName = SEQUENCENAME, initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCENAME)
    @Column(name = "ID_STAFFING", length = 10)
	private Long id;
	/**
	 * The client.
	 */
    @Column(name = "CLIENT", length = 100)
    private String client;
    /**
     * Start date of collaboration.
     */
    @Column(name = "DATE_BEGIN")
	private Date dateBegin;
	/**
	 * End date of collaboration.
	 */
    @Column(name = "DATE_END")
    private Date dateEnd;
    /**
     * The reason of the leaving.
     */
    @Column(name = "REASON", length = 255)
    private String reason;
    /**
     * Average daily rate.
     */
    @Column(name = "AVERAGE_DAILY_RATE", length =5)
    private Long averageDailyRate;
    /**
     * The marketing.
     */
    private User user;
    /**
     * The profile related to the staffing.
     */
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
	 * @return the client
	 */
	public String getClient() {
		return client;
	}
	/**
	 * @param client the client to set
	 */
	public void setClient(String client) {
		this.client = client;
	}
	/**
	 * @return the dateBegin
	 */
	public Date getDateBegin() {
		return dateBegin;
	}
	/**
	 * @param dateBegin the dateBegin to set
	 */
	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}
	/**
	 * @return the dateEnd
	 */
	public Date getDateEnd() {
		return dateEnd;
	}
	/**
	 * @param dateEnd the dateEnd to set
	 */
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	 * @return the averageDailyRate
	 */
	public Long getAverageDailyRate() {
		return averageDailyRate;
	}
	/**
	 * @param averageDailyRate the averageDailyRate to set
	 */
	public void setAverageDailyRate(Long averageDailyRate) {
		this.averageDailyRate = averageDailyRate;
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
