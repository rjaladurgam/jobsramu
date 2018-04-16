package com.jvr.repo;

import org.springframework.data.repository.CrudRepository;

import com.jvr.entity.Service;

public interface ServiceRepository extends  CrudRepository<Service, Long> {

}
