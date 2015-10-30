package com.paloit.paloma.dto;

import com.paloit.paloma.domain.Office;

import java.util.Date;

public class ContractDTO {
    private Boolean decision;
    private String reason;
    private Date dateProject;
    private Office office;
    private Date dateSignature;
    private Long fixedSalary;
    private Date dateBegin;
    private Long variableSalary;
    private Date dateEnd;
    private String comment;

    public ContractDTO() {
    }

    public Boolean getDecision() {
        return decision;
    }

    public void setDecision(Boolean decision) {
        this.decision = decision;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getDateProject() {
        return dateProject;
    }

    public void setDateProject(Date dateProject) {
        this.dateProject = dateProject;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Date getDateSignature() {
        return dateSignature;
    }

    public void setDateSignature(Date dateSignature) {
        this.dateSignature = dateSignature;
    }

    public Long getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(Long fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Long getVariableSalary() {
        return variableSalary;
    }

    public void setVariableSalary(Long variableSalary) {
        this.variableSalary = variableSalary;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
