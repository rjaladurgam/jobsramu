package com.jvr.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Offering {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    //private Long userID;
    private int serviceID;
    private Date startTime;
    private Date endTime;
    @OneToOne
    @JoinColumn(name="user_ID", nullable = true)
    private User user;
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    } 
  

    public Offering() {
        
    }

    public Offering(int serviceID, Date startTime, Date endTime) {
        //this.userID = userID;
        this.serviceID = serviceID;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Offering [id=" + id + /*", userID=" + userID +*/ ", serviceID=" + serviceID + ", startTime=" + startTime + ", endTime=" + endTime + ", username=" + user.getUserID() + "]";
    }

    public Long getId() {
        return id;
    }

    /*
    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }*/

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    
    
    
}
