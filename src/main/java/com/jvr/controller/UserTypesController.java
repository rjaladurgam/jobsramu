package com.jvr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvr.entity.UserTypes;
import com.jvr.repo.UserTypesRepository;

@RestController
@RequestMapping("/api")
public class UserTypesController {

    @Autowired
    UserTypesRepository userTypesRepository;
    
    @GetMapping("/usertypes")
    public List<UserTypes> getAllUserTypes() {
        return (List<UserTypes>) userTypesRepository.findAll();
    }
    
}
