package com.paloit.paloma.dto;

import com.paloit.paloma.domain.Staffing;
import com.paloit.paloma.utils.enums.StaffingStatus;

import java.util.List;

public class CareerDTO {

    private StaffingStatus staffingStatus;
    private int experience;
    private long minAverageDailyRate;
    private List<Staffing> staffings;

    public CareerDTO() {
    }

    public StaffingStatus getStaffingStatus() {
        return staffingStatus;
    }

    public void setStaffingStatus(StaffingStatus staffingStatus) {
        this.staffingStatus = staffingStatus;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public long getMinAverageDailyRate() {
        return minAverageDailyRate;
    }

    public void setMinAverageDailyRate(long minAverageDailyRate) {
        this.minAverageDailyRate = minAverageDailyRate;
    }

    public List<Staffing> getStaffings() {
        return staffings;
    }

    public void setStaffings(List<Staffing> staffings) {
        this.staffings = staffings;
    }
}
