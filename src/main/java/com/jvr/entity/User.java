package com.jvr.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String userID;
    private String firstName;
    private String lastName;
    private String email;
    private String userTypeID;
    private String password;
    
    /*
    @OneToMany(fetch = FetchType.LAZY,
        cascade =  CascadeType.ALL,
        mappedBy = "user")
    private List<Offering> offerings;
    */
    
    protected User() {
        
    }
    
    public User(String userID, String firstName, String lastName, String email, String userTypeID, String password) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userTypeID = userTypeID;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserTypeID() {
        return userTypeID;
    }

    public void setUserTypeID(String userTypeID) {
        this.userTypeID = userTypeID;
    }

}
