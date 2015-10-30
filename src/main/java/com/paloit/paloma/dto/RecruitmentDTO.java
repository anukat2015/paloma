package com.paloit.paloma.dto;

public class RecruitmentDTO {

    private QualificationDTO qualification;
    private InterviewDTO interview;
    private ContractDTO contract;

    public RecruitmentDTO() {
    }

    public QualificationDTO getQualification() {
        return qualification;
    }

    public void setQualification(QualificationDTO qualification) {
        this.qualification = qualification;
    }

    public InterviewDTO getInterview() {
        return interview;
    }

    public void setInterview(InterviewDTO interview) {
        this.interview = interview;
    }

    public ContractDTO getContract() {
        return contract;
    }

    public void setContract(ContractDTO contract) {
        this.contract = contract;
    }
}
