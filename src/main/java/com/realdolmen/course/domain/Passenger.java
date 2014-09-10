package com.realdolmen.course.domain;

import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by TLAAU71 on 8/09/2014.
 */
@Entity
public class Passenger {

    static enum PassengerType{OCCASIONAL, REGULAR}

    private static Logger logger = org.slf4j.LoggerFactory.getLogger(Passenger.class);

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, updatable = false)
    private String ssn;
    @Column(length = 50)
    private String lastName;
    @Column(length = 50)
    private String firstName;
    private int frequentFlyerMiles;
    private byte[] picture;
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Transient
    private Integer age;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PassengerType passengerType;
    @Temporal(TemporalType.DATE)
    private Date lastFlight;
    @Temporal(TemporalType.DATE)
    private Date dateLastUpdated;

    @PrePersist
    private void updateTime(){
        logger.info("Generating updateTime for entitty with name " + firstName +" "+ lastName);
        dateLastUpdated = new Date();
    }

    protected Passenger() {

    }

    public Passenger(String ssn, String lastName, String firstName, int frequentFlyerMiles, byte[] picture, Date dateOfBirth, PassengerType passengerType, Date lastFlight) {
        this.ssn = ssn;
        this.lastName = lastName;
        this.firstName = firstName;
        this.frequentFlyerMiles = frequentFlyerMiles;
        this.picture = picture;
        this.dateOfBirth = dateOfBirth;
        this.passengerType = passengerType;
        this.lastFlight = lastFlight;
        Date time = new Date();
        if(dateOfBirth != null)
            time.setTime(new Date().getTime() - dateOfBirth.getTime());
        age = time.getYear();

    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Integer getAge() {
        return age;
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public Date getLastFlight() {
        return lastFlight;
    }

    public Long getId() {
        return id;
    }

    public String getSsn() {
        return ssn;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    public byte[] getPicture() {
        return picture;
    }

    public Date getDateLastUpdated() {
        return dateLastUpdated;
    }

    public static void setLogger(Logger logger) {
        Passenger.logger = logger;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setFrequentFlyerMiles(int frequentFlyerMiles) {
        this.frequentFlyerMiles = frequentFlyerMiles;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPassengerType(PassengerType passengerType) {
        this.passengerType = passengerType;
    }

    public void setLastFlight(Date lastFlight) {
        this.lastFlight = lastFlight;
    }

    public void setDateLastUpdated(Date dateLastUpdated) {
        this.dateLastUpdated = dateLastUpdated;
    }
}
