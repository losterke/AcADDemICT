package com.realdolmen.course.domain;

import com.sun.istack.internal.NotNull;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by TLAAU71 on 8/09/2014.
 */
@Entity
public class Passenger {

    static enum PassengerType{OCCASIONAL, REGULAR}

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
    private Byte[] picture;
    @Column(nullable = false, updatable = false)
    private Date dateOfBirth;
    @Transient
    private Integer age;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PassengerType passengerType;
    private Date lastFlight;

    protected Passenger() {

    }

    public Passenger(String ssn, String lastName, String firstName, int frequentFlyerMiles, Byte[] picture, Date dateOfBirth, PassengerType passengerType, Date lastFlight) {
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

    public Byte[] getPicture() {
        return picture;
    }
}
