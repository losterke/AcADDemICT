package com.realdolmen.course.domain;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by TLAAU71 on 10/09/2014.
 */
@Entity
public class DomesticFlight extends Flight {

    private String airlineCompany;
    @ElementCollection
    private Collection<String> references = new ArrayList<>();


    protected DomesticFlight(){

    }

    public DomesticFlight(Long id, String number, Date departureTime, Date arrivalTime, String airlineCompany, Collection<String> references) {
        super(id, number, departureTime, arrivalTime);
        this.airlineCompany = airlineCompany;
        this.references = references;
    }

    public String getAirlineCompany() {
        return airlineCompany;
    }

    public void setAirlineCompany(String airlineCompany) {
        this.airlineCompany = airlineCompany;
    }

    public Collection<String> getReferences() {
        return references;
    }

    public void setReferences(Collection<String> references) {
        this.references = references;
    }
}
