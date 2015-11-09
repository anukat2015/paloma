package com.paloit.paloma.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Connection account of the app and marketing account.
 * @author Yu
 * @since 10/27/2015
 */
@Entity
@Table(name="USER")
public class User extends BusinessEntity<Long> {

	/**
	 * The generated serial UID
	 */
	private static final long serialVersionUID = 3521699924725634358L;
	/**
     * Sequence name.
     */
    private static final String SEQUENCENAME = "SEQUENCE_USER";
	/**
	 * The id.
	 */
	@Id
    @SequenceGenerator(name = SEQUENCENAME, sequenceName = SEQUENCENAME, initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCENAME)
    @Column(name = "ID_USER", length = 10)
    private Long id;
	/**
	 * Email.
	 */
	@Column(name = "EMAIL", length = 100)
    private String email;
    /**
     * Password.
     */
	@Column(name = "PASSWORD", length = 100)
    private String password;
    /**
     * First Name.
     */
	@Column(name = "FIRST_NAME", length = 50)
    private String firstName;
    /**
     * Last Name.
     */
	@Column(name = "LAST_NAME", length = 50)
    private String lastName;
    /**
     * Date of creation.
     */
	@Column(name = "CREATION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
    private Calendar createdDate;
    /**
     * Active / desactivate.
     */
	@Column(name = "IS_BANNED")
    private Boolean isBanned;
	
	/**
	 * User right.
	 */
	@ManyToOne
	@JoinColumn(name = "ID_USER_STATUS")
	private UserStatus userStatus;
	
	/**
	 * The id provided by Google SSO WS
	 */
	private String googleId;
	
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the createdDate
	 */
	public Calendar getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the isBanned
	 */
	public Boolean getIsBanned() {
		return isBanned;
	}
	/**
	 * @param isBanned the isBanned to set
	 */
	public void setIsBanned(Boolean isBanned) {
		this.isBanned = isBanned;
	}
	/**
	 * @return the userStatus
	 */
	public UserStatus getUserStatus() {
		return userStatus;
	}
	/**
	 * @param userStatus the userStatus to set
	 */
	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}
	
	/**
	 * @return the googleId
	 */
	public String getGoogleId() {
		return googleId;
	}
	/**
	 * @param googleId the googleId to set
	 */
	public void setGoogleId(String googleId) {
		this.googleId = googleId;
	}
   
}
