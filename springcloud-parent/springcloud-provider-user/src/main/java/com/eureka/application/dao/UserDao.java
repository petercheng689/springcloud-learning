package com.eureka.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eureka.application.entity.User;


@Repository
public interface UserDao extends JpaRepository<User, Long>{
}
