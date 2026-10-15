package com.example.LinkClubProject.ConnectionService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LinkClubProject.ConnectionService.entity.Person;
import com.example.LinkClubProject.ConnectionService.repository.Personrepository;


@Service 
public class ConnectionService {

    @Autowired Personrepository personrepository;

    public List<Person> getfirstdegreepersons(Long userid){
        
        return personrepository.firstdegrePersons(userid);

    }
    
}
