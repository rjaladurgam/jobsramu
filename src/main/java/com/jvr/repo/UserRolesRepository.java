package com.jvr.repo;

import org.springframework.data.repository.CrudRepository;

import com.jvr.entity.UserRole;

public interface UserRolesRepository extends CrudRepository<UserRole, Long>{
    
    UserRole findByUserID(String userID);

}
