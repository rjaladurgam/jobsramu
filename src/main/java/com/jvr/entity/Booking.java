package com.jvr.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Booking {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long offeringID;
    private Long userID;
    
    protected Booking() {
        
    }

    public Booking(Long offeringID, Long userID) {
        this.offeringID = offeringID;
        this.userID = userID;
    }

    public Long getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Booking [id=" + id + ", offeringID=" + offeringID + ", userID=" + userID + "]";
    }

    public Long getOfferingID() {
        return offeringID;
    }

    public void setOfferingID(Long offeringID) {
        this.offeringID = offeringID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }
    
    
}
