package com.paloit.paloma.domain;

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
 * Created by Yu on 27/10/2015.
 */
@Entity
@Table(name="Contact")
public class Contact {

	/**
     * Sequence name.
     */
    private static final String SEQUENCENAME = "SEQUENCE_CONTACT";
  
	/**
	 * Contact id.
	 */
    @Id
    @SequenceGenerator(name = SEQUENCENAME, sequenceName = SEQUENCENAME, initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCENAME)
    @Column(name = "ID_CONTACT", length = 10)
	private Long id;
    
    @Column(name = "PHONE_NUMBER", length = 20)
    private String phoneNumber;
    
    @Column(name = "EMAIL", length = 100)
    private String email;
    
    @Column(name = "PRO_EMAIL", length = 100)
    private String proEmail;
    
    @ManyToOne
    @JoinColumn(name = "ID_COUNTRY")
    private Country country;
    
    @Column(name = "CITY", length = 50)
    private String city;
    
    @Column(name = "ADDRESS", length = 100)
    private String address;
    
    @Column(name = "ZIP", length = 20)
    private String zip;

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
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	 * @return the proEmail
	 */
	public String getProEmail() {
		return proEmail;
	}

	/**
	 * @param proEmail the proEmail to set
	 */
	public void setProEmail(String proEmail) {
		this.proEmail = proEmail;
	}

	/**
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(Country country) {
		this.country = country;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
    
	
    
    
}
