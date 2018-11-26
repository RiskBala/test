package com.fsd.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsd.projectmanager.entity.User;

@Repository
public interface UserManagerRepository extends JpaRepository<User,String>{

}
