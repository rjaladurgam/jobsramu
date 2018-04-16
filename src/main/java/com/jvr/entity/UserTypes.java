package com.jvr.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserTypes {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String userType;
    
    protected UserTypes() {
        
    }
    
    public UserTypes(String userType) {
        this.userType = userType;
    }
    
    public String getUserType() {
        return userType;
    }
}