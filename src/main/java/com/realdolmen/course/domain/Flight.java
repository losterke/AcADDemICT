package com.realdolmen.course.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by TLAAU71 on 10/09/2014.
 */
@Entity
public class Flight {

    @Id
    @GeneratedValue
    private Long Id;
    private String number;
    @Temporal(TemporalType.TIME)
    private Date departureTime;
    @Temporal(TemporalType.TIME)
    private Date arrivalTime;

    @OneToMany(mappedBy = "flight")
    private List<Ticket> tickets = new ArrayList<Ticket>();

    protected Flight(){
    }

    public Flight(Long id, String number, Date departureTime, Date arrivalTime) {
        Id = id;
        this.number = number;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String nummer) {
        this.number = nummer;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

}
