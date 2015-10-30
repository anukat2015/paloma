package com.paloit.paloma.dto;

import com.paloit.paloma.domain.Interview;

import java.util.List;

public class InterviewDTO {
    private List<Interview> interviewList;
    private String idQualification;
    private String idTest;

    public InterviewDTO() {
    }

    public List<Interview> getInterviewList() {
        return interviewList;
    }

    public void setInterviewList(List<Interview> interviewList) {
        this.interviewList = interviewList;
    }

    public String getIdQualification() {
        return idQualification;
    }

    public void setIdQualification(String idQualification) {
        this.idQualification = idQualification;
    }

    public String getIdTest() {
        return idTest;
    }

    public void setIdTest(String idTest) {
        this.idTest = idTest;
    }
}
