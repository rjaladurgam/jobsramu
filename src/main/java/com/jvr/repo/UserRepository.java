package com.jvr.repo;

import org.springframework.data.repository.CrudRepository;

import com.jvr.entity.User;
import com.jvr.entity.UserRole;

public interface UserRepository extends CrudRepository<User, Long>{
    
    User findByUserID(String userID);
    
 }
