/**
 * 
 */
package com.paloit.paloma.dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author DTRANG, SLOPES
 * @version 0.0.1
 * Class used to map google authentication data.
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class UserGoogleDTO {
	/**
	 * The id
	 */
	private String id;
	
	/**
	 * The email
	 */
	private String email;
	
	/**
	 * The first name
	 */
	@JsonProperty("given_name")
	private String firstName;
	
	/**
	 * The family name
	 */
	@JsonProperty("family_name")
	private String familyName;
	
	/**
	 * The domain
	 */
	@JsonProperty("hd")
	private String domain;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
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
	 * @return the familyName
	 */
	public String getFamilyName() {
		return familyName;
	}

	/**
	 * @param familyName the familyName to set
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	/**
	 * @return the domain
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * @param domain the domain to set
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	public String toString(){
		return this.getClass().getSimpleName() + " #" + this.id + 
				" " + this.firstName + " " + this.familyName; 
	}

}
