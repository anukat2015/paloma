package com.paloit.paloma.domain;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.paloit.paloma.utils.enums.TypeContract;

/**
 * Contract of the profile.
 * Created by Yu on 27/10/2015.
 */
@Entity
@Table(name="CONTRACT")
public class Contract {
	
	/**
     * Sequence name.
     */
    private static final String SEQUENCENAME = "SEQUENCE_CONTRACT";
  
	/**
	 * Contract id.
	 */
    @Id
    @SequenceGenerator(name = SEQUENCENAME, sequenceName = SEQUENCENAME, initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCENAME)
    @Column(name = "ID_CONTRACT", length = 10)
	private Long id;
    
    /**
     * Contract project Date.
     */
    @Column(name="DATE_CONTRACT_PROJECT")
    private Date dateProject;
    
    /**
     * GO, NO GO.
     */
    @Column(name="DECISION")
    private Boolean decision;
    
    /**
     * Comment.
     */
    @Column(name="COMMENT", length=255)
    private String comment;
    
    /**
     * Reason of refusal.
     */
    @Column(name="REASON", length=255)
    private String reason;
    
    /**
     * Signature Date.
     */
    @Column(name="DATE_CONTRACT_SIGNATURE")
    private Date dateSignature;
    
    /**
     * Start Date.
     */
    @Column(name="DATE_CONTRACT_BEGIN")
    private Date dateBegin;
    
    /**
     * Fixed salary.
     */
    @Column(name="FIXED_SALARY")
    private Long fixedSalary;
    
    /**
     * Variable salary.
     */
    @Column(name="VARIABLE_SALARY")
    private Long variableSalary;
    
    /**
     * Office of the contract.
     */
    @ManyToOne
    @JoinColumn(name = "ID_OFFICE")
    private Office office;
    
    /**
     * End Date of contract.
     */
    @Column(name="DATE_CONTRACT_BEGIN")
    private Date dateEnd;
    
    /**
     * Type of contract.
     */
    @Enumerated(EnumType.STRING)
    @Column(name="TYPE_CONTRACT")
    private TypeContract typeContract;
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
	 * @return the dateProject
	 */
	public Date getDateProject() {
		return dateProject;
	}
	/**
	 * @param dateProject the dateProject to set
	 */
	public void setDateProject(Date dateProject) {
		this.dateProject = dateProject;
	}
	/**
	 * @return the decision
	 */
	public Boolean getDecision() {
		return decision;
	}
	/**
	 * @param decision the decision to set
	 */
	public void setDecision(Boolean decision) {
		this.decision = decision;
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
	 * @return the dateSignature
	 */
	public Date getDateSignature() {
		return dateSignature;
	}
	/**
	 * @param dateSignature the dateSignature to set
	 */
	public void setDateSignature(Date dateSignature) {
		this.dateSignature = dateSignature;
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
	 * @return the fixedSalary
	 */
	public Long getFixedSalary() {
		return fixedSalary;
	}
	/**
	 * @param fixedSalary the fixedSalary to set
	 */
	public void setFixedSalary(Long fixedSalary) {
		this.fixedSalary = fixedSalary;
	}
	/**
	 * @return the variableSalary
	 */
	public Long getVariableSalary() {
		return variableSalary;
	}
	/**
	 * @param variableSalary the variableSalary to set
	 */
	public void setVariableSalary(Long variableSalary) {
		this.variableSalary = variableSalary;
	}
	/**
	 * @return the office
	 */
	public Office getOffice() {
		return office;
	}
	/**
	 * @param office the office to set
	 */
	public void setOffice(Office office) {
		this.office = office;
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
	 * @return the typeContract
	 */
	public TypeContract getTypeContract() {
		return typeContract;
	}
	/**
	 * @param typeContract the typeContract to set
	 */
	public void setTypeContract(TypeContract typeContract) {
		this.typeContract = typeContract;
	}
    
    
}
