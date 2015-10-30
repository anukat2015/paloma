package com.paloit.paloma.dto;

import com.paloit.paloma.domain.Source;
import com.paloit.paloma.utils.enums.TypeContract;
import com.paloit.paloma.utils.enums.TypeSourcing;

import java.util.Date;

public class QualificationDTO {
    private Source source;
    private TypeSourcing typeSourcing;
    private String noticePrior;
    private Date dateAvailable;
    private String mobility;
    private Long salaryWish;
    private TypeContract typeContract;

    public QualificationDTO() {
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public TypeSourcing getTypeSourcing() {
        return typeSourcing;
    }

    public void setTypeSourcing(TypeSourcing typeSourcing) {
        this.typeSourcing = typeSourcing;
    }

    public String getNoticePrior() {
        return noticePrior;
    }

    public void setNoticePrior(String noticePrior) {
        this.noticePrior = noticePrior;
    }

    public Date getDateAvailable() {
        return dateAvailable;
    }

    public void setDateAvailable(Date dateAvailable) {
        this.dateAvailable = dateAvailable;
    }

    public String getMobility() {
        return mobility;
    }

    public void setMobility(String mobility) {
        this.mobility = mobility;
    }

    public Long getSalaryWish() {
        return salaryWish;
    }

    public void setSalaryWish(Long salaryWish) {
        this.salaryWish = salaryWish;
    }

    public TypeContract getTypeContract() {
        return typeContract;
    }

    public void setTypeContract(TypeContract typeContract) {
        this.typeContract = typeContract;
    }
}
