package com.paloit.paloma.dto;

import com.paloit.paloma.domain.ProfileLanguage;
import com.paloit.paloma.domain.Skill;

import java.util.Date;
import java.util.List;

public class SkillDTO {
    private String title;
    private List<Skill> skills;
    private String diploma;
    private Date diplomaDate;
    private String idDriveDoc;
    private List<ProfileLanguage> profileLanguages;

    public SkillDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public String getDiploma() {
        return diploma;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    public Date getDiplomaDate() {
        return diplomaDate;
    }

    public void setDiplomaDate(Date diplomaDate) {
        this.diplomaDate = diplomaDate;
    }

    public String getIdDriveDoc() {
        return idDriveDoc;
    }

    public void setIdDriveDoc(String idDriveDoc) {
        this.idDriveDoc = idDriveDoc;
    }

    public List<ProfileLanguage> getProfileLanguages() {
        return profileLanguages;
    }

    public void setProfileLanguages(List<ProfileLanguage> profileLanguages) {
        this.profileLanguages = profileLanguages;
    }
}
