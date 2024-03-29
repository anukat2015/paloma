package com.paloit.paloma.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Right management bean.
 * @author DTRANG
 *
 */
@Entity
@Table(name="USER_STATUS")
public class UserStatus {
	
	/**
     * Sequence name.
     */
    private static final String SEQUENCENAME = "SEQUENCE_USER_STATUS";
  
	/**
	 * User status id.
	 */
    @Id
    @SequenceGenerator(name = SEQUENCENAME, sequenceName = SEQUENCENAME, initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCENAME)
    @Column(name = "ID_USER_STATUS", length = 10)
	private Long id;

	/**
	 * Title of the status.
	 */
    @Column(name = "TITLE", length = 50)
	private String title;
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy = "userStatus")
    private List<User> users;

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

	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
}
