package com.example.LinkClubProject.userService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LinkClubProject.userService.Entity.User;
import java.util.List;


@Repository 
public interface UserRepository extends  JpaRepository <User,Long>{

      boolean existsByEmail(String email);

      List<User> findByEmail(String email);

}
