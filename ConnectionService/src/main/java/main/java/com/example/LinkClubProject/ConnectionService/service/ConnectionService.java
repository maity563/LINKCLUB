package main.java.com.example.LinkClubProject.ConnectionService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.example.LinkClubProject.ConnectionService.entity.Person;
import main.java.com.example.LinkClubProject.ConnectionService.repository.Personrepository;

@Service 
public class ConnectionService {

    @Autowired Personrepository personrepository;

    public List<Person> getfirstdegreepersons(Long userid){
        
        return personrepository.firstdegrePersons(userid);

    }
    
}
