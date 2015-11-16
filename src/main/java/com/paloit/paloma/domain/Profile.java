package com.paloit.paloma.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.paloit.paloma.utils.enums.StaffingStatus;
import com.paloit.paloma.utils.enums.StatusContact;
import com.paloit.paloma.utils.enums.StatusRecruitment;
import com.paloit.paloma.utils.enums.TypeSourcing;

@Entity
@Table(name="PROFILE")
public class Profile extends BusinessEntity<Long> {
	/**
	 * The generated serial UID
	 */
	private static final long serialVersionUID = -5391998537911235000L;

	/**
     * Sequence name.
     */
    private static final String SEQUENCENAME = "SEQUENCE_PROFILE";
  
	/**
	 * Profile id.
	 */
    @Id
    @SequenceGenerator(name = SEQUENCENAME, sequenceName = SEQUENCENAME, initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCENAME)
    @Column(name = "ID_PROFILE", length = 10)
    private Long id;
    
    /**
     * Title of the profile.
     */
    @Column(name = "TITLE", length = 100)
    private String title;
    
    /**
     * List of skills.
     */
    @ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "PROFILE_SKILL", joinColumns={@JoinColumn(name="ID_PROFILE", referencedColumnName="ID_PROFILE")},
		      inverseJoinColumns={@JoinColumn(name="ID_SKILL", referencedColumnName="ID_SKILL")})    
    private List<Skill> skills;
    
    /**
     * Drive doc id.
     */
    @Column(name = "ID_DRIVE_DOC", length = 100)
    private String idDriveDoc;
    
    /**
     * Type of contract.
     */
    @Enumerated(EnumType.STRING)
    @Column(name="STATUS_RECRUITMENT")
    private StatusRecruitment statusRecruitment;
    
    /**
     * To contact or not anymore.
     */
    @Enumerated(EnumType.STRING)
    @Column(name="STATUS_CONTACT")
    private StatusContact statusContact;
    
    /**
     * Number of experiences.
     */
    @Column(name = "EXPERIENCE", length = 3)
    private Integer experience;
    
    /**
     * Source of the profiles.
     */
    @ManyToOne
    @JoinColumn(name = "ID_SOURCE")
    private Source source;
    
    /**
     * Sourcing Type.
     */
    @Enumerated(EnumType.STRING)
    @Column(name="TYPE_SOURCING")
    private TypeSourcing typeSourcing;
    
    /**
     * Notice Prior.
     */
    @Column(name = "NOTICE_PRIOR", length = 50)
    private String noticePrior;
    
    /**
     * Date of availability.
     */
    @Column(name = "DATE_AVAILABLE")
    private Date dateAvailable;
    
    /**
     * Mobility.
     */
    @Column(name = "MOBILITY", length = 100)
    private String mobility;
    
    /**
     * Salary wished by the profile.
     */
    @Column(name="SALARY_WISH", length=10)
    private Long salaryWish;
    
    /**
     * Minimum daily rate.
     */
    @Column(name="MIN_AVERAGE_DAILY_RATE", length=5)
    private Long minAverageDailyRate;
    
    /**
     * Available or in mission.
     */
    @Enumerated(EnumType.STRING)
    @Column(name="STAFFING_STATUS")
    private StaffingStatus staffingStatus;
    
    /**
     * Most significant diploma of the profile.
     */
    @Column(name="DIPLOMA", length=100)
    private String diploma;
    
    /**
     * Date of the diploma.
     */
    @Column(name="DATE_DIPLOMA")
    private Date diplomaDate;
    
    /**
     * First name of the profile.
     */
    @Column(name="FIRST_NAME", length=100)
    private String firstName;
    
    /**
     * Last name of the profile.
     */
    @Column(name="LAST_NAME", length=100)
    private String lastName;
    
    /**
     * Birth date of the profile.
     */
    @Column(name="DATE_BIRTH")
    @Temporal(TemporalType.DATE)
    private Calendar birthDate;
    
    /**
     * contact.
     */
    @OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "ID_CONTACT")
    private Contact contact;

    /**
     * List of interview.
     */
    @OneToMany(fetch=FetchType.LAZY, mappedBy = "profile",cascade=CascadeType.ALL)
    private List<Interview> interviews;
    
    /**
     * Qualification id.
     */
    @Column(name = "ID_QUALIFICATION", length = 100)
    private String idQualification;
    
    /**
     * Test id.
     */
    @Column(name = "ID_TEST", length = 100)
    private String idTest;

    /**
     * Source of the profiles.
     */
    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "ID_CONTRACT")
    private Contract contract;

    /**
     * CAREER Historical.
     */
    @OneToMany(fetch=FetchType.LAZY, mappedBy = "profile" ,cascade=CascadeType.ALL)
    private List<Staffing> staffings;

    /**
     * List of languages
     */
    @OneToMany(mappedBy="profileLanguageId.profile", cascade=CascadeType.ALL)
    private List<ProfileLanguage> profileLanguages;
    
    
    /**
     * Profile deleted.
     */
    @Column(name = "IS_DELETED")
    private Boolean isDeleted;
    
    /**
     * Modified date.
     */
    @Column(name = "DATE_MODIFIED")
    private Calendar modifiedDate;
    
    /**
     * Last user who has edited the profile.
     */
    @ManyToOne
    @JoinColumn(name = "ID_USER")
    private User user;

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
	 * @return the skills
	 */
	public List<Skill> getSkills() {
		return skills;
	}

	/**
	 * @param skills the skills to set
	 */
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	/**
	 * @return the idDriveDoc
	 */
	public String getIdDriveDoc() {
		return idDriveDoc;
	}

	/**
	 * @param idDriveDoc the idDriveDoc to set
	 */
	public void setIdDriveDoc(String idDriveDoc) {
		this.idDriveDoc = idDriveDoc;
	}

	/**
	 * @return the statusRecruitment
	 */
	public StatusRecruitment getStatusRecruitment() {
		return statusRecruitment;
	}

	/**
	 * @param statusRecruitment the statusRecruitment to set
	 */
	public void setStatusRecruitment(StatusRecruitment statusRecruitment) {
		this.statusRecruitment = statusRecruitment;
	}

	/**
	 * @return the experience
	 */
	public Integer getExperience() {
		return experience;
	}

	/**
	 * @param experience the experience to set
	 */
	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	/**
	 * @return the source
	 */
	public Source getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(Source source) {
		this.source = source;
	}

	/**
	 * @return the typeSourcing
	 */
	public TypeSourcing getTypeSourcing() {
		return typeSourcing;
	}

	/**
	 * @param typeSourcing the typeSourcing to set
	 */
	public void setTypeSourcing(TypeSourcing typeSourcing) {
		this.typeSourcing = typeSourcing;
	}

	/**
	 * @return the noticePrior
	 */
	public String getNoticePrior() {
		return noticePrior;
	}

	/**
	 * @param noticePrior the noticePrior to set
	 */
	public void setNoticePrior(String noticePrior) {
		this.noticePrior = noticePrior;
	}

	/**
	 * @return the dateAvailable
	 */
	public Date getDateAvailable() {
		return dateAvailable;
	}

	/**
	 * @param dateAvailable the dateAvailable to set
	 */
	public void setDateAvailable(Date dateAvailable) {
		this.dateAvailable = dateAvailable;
	}

	/**
	 * @return the mobility
	 */
	public String getMobility() {
		return mobility;
	}

	/**
	 * @param mobility the mobility to set
	 */
	public void setMobility(String mobility) {
		this.mobility = mobility;
	}

	/**
	 * @return the salaryWish
	 */
	public Long getSalaryWish() {
		return salaryWish;
	}

	/**
	 * @param salaryWish the salaryWish to set
	 */
	public void setSalaryWish(Long salaryWish) {
		this.salaryWish = salaryWish;
	}

	/**
	 * @return the minAverageDailyRate
	 */
	public Long getMinAverageDailyRate() {
		return minAverageDailyRate;
	}

	/**
	 * @param minAverageDailyRate the minAverageDailyRate to set
	 */
	public void setMinAverageDailyRate(Long minAverageDailyRate) {
		this.minAverageDailyRate = minAverageDailyRate;
	}

	/**
	 * @return the diploma
	 */
	public String getDiploma() {
		return diploma;
	}

	/**
	 * @param diploma the diploma to set
	 */
	public void setDiploma(String diploma) {
		this.diploma = diploma;
	}

	/**
	 * @return the diplomaDate
	 */
	public Date getDiplomaDate() {
		return diplomaDate;
	}

	/**
	 * @param diplomaDate the diplomaDate to set
	 */
	public void setDiplomaDate(Date diplomaDate) {
		this.diplomaDate = diplomaDate;
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
	 * @return the birthDate
	 */
	public Calendar getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}
	
	/**
	 * @return the interviews
	 */
	public List<Interview> getInterviews() {
		return interviews;
	}

	/**
	 * @param interviews the interviews to set
	 */
	public void setInterviews(List<Interview> interviews) {
		this.interviews = interviews;
	}

	/**
	 * @return the idQualification
	 */
	public String getIdQualification() {
		return idQualification;
	}

	/**
	 * @param idQualification the idQualification to set
	 */
	public void setIdQualification(String idQualification) {
		this.idQualification = idQualification;
	}

	/**
	 * @return the staffingStatus
	 */
	public StaffingStatus getStaffingStatus() {
		return staffingStatus;
	}

	/**
	 * @param staffingStatus the staffingStatus to set
	 */
	public void setStaffingStatus(StaffingStatus staffingStatus) {
		this.staffingStatus = staffingStatus;
	}

	/**
	 * @return the idTest
	 */
	public String getIdTest() {
		return idTest;
	}

	/**
	 * @param idTest the idTest to set
	 */
	public void setIdTest(String idTest) {
		this.idTest = idTest;
	}

	/**
	 * @return the profileLanguages
	 */
	public List<ProfileLanguage> getProfileLanguages() {
		return profileLanguages;
	}

	/**
	 * @param profileLanguages the profileLanguages to set
	 */
	public void setProfileLanguages(List<ProfileLanguage> profileLanguages) {
		this.profileLanguages = profileLanguages;
	}

	/**
	 * @return the contract
	 */
	public Contract getContract() {
		return contract;
	}

	/**
	 * @param contract the contract to set
	 */
	public void setContract(Contract contract) {
		this.contract = contract;
	}

	
	/**
	 * @return the staffings
	 */
	public List<Staffing> getStaffings() {
		return staffings;
	}

	/**
	 * @param staffings the staffings to set
	 */
	public void setStaffings(List<Staffing> staffings) {
		this.staffings = staffings;
	}

	/**
	 * @return the isDeleted
	 */
	public Boolean getIsDeleted() {
		return isDeleted;
	}

	/**
	 * @param isDeleted the isDeleted to set
	 */
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * @return the modifiedDate
	 */
	public Calendar getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedDate(Calendar modifiedDate) {
		this.modifiedDate = modifiedDate;
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
	 * @return the statusContact
	 */
	public StatusContact getStatusContact() {
		return statusContact;
	}

	/**
	 * @param statusContact the statusContact to set
	 */
	public void setStatusContact(StatusContact statusContact) {
		this.statusContact = statusContact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}

	/**
	 * @return the contact
	 */
	public Contact getContact() {
		return contact;
	}

	
	
}
