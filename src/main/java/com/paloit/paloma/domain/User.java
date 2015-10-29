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
 * Connection account of the app and marketing account.
 * Created by Yu on 27/10/2015.
 */
@Entity
@Table(name="USER")
public class User {

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
    private Date createdDate;
    /**
     * Active / desactivate.
     */
	@Column(name = "IS_BANNED")
    private Boolean isBanned;
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
	public Date getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
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

   
}
