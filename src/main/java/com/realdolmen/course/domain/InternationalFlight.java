package com.realdolmen.course.domain;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by TLAAU71 on 10/09/2014.
 */
@Entity
public class InternationalFlight extends Flight {

    private Boolean blacklisted;
    private String regulations;

    protected InternationalFlight(){

    }

    public InternationalFlight(Long id, String number, Date departureTime, Date arrivalTime, Boolean blacklisted, String regulations) {
        super(id, number, departureTime, arrivalTime);
        this.blacklisted = blacklisted;
        this.regulations = regulations;
    }

    public Boolean getBlacklisted() {
        return blacklisted;
    }

    public void setBlacklisted(Boolean blacklisted) {
        this.blacklisted = blacklisted;
    }

    public String getRegulations() {
        return regulations;
    }

    public void setRegulations(String regulations) {
        this.regulations = regulations;
    }
}
