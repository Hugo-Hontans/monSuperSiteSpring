package com.monSuperSite.monSuperSiteSpring.repo;

import org.springframework.data.repository.CrudRepository;

import com.monSuperSite.monSuperSiteSpring.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
