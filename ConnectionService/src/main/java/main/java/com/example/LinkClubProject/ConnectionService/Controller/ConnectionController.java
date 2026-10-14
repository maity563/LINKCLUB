package main.java.com.example.LinkClubProject.ConnectionService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.java.com.example.LinkClubProject.ConnectionService.entity.Person;
import main.java.com.example.LinkClubProject.ConnectionService.service.ConnectionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
@RequestMapping ("/core")
public class ConnectionController {

    @Autowired private ConnectionService connectionService;


    @GetMapping("/{userId}/first-degree-users")
    public ResponseEntity<?> getMethodName(@PathVariable Long userId) {
        
        List<Person> p=connectionService.getfirstdegreepersons(userId);


        return new ResponseEntity<>(p,HttpStatus.CREATED);
    }
    
    
}
