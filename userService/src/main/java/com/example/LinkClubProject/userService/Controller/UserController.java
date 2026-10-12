package com.example.LinkClubProject.userService.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LinkClubProject.userService.DTO.LoginRequestDTO;
import com.example.LinkClubProject.userService.DTO.SignUpRequestDTO;
import com.example.LinkClubProject.userService.DTO.UserDTO;
import com.example.LinkClubProject.userService.Service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping ("/auth")
public class UserController {

    @Autowired private AuthService authService;
    
    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signupmethod(@RequestBody SignUpRequestDTO signUpRequestDTO) {
        
          UserDTO userDTO=authService.signup(signUpRequestDTO);
          
          return new ResponseEntity<>(userDTO,HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public ResponseEntity<String> logincreated(@RequestBody LoginRequestDTO loginRequestDTO) {
        
        String token=authService.login(loginRequestDTO);

        return new ResponseEntity<>(token,HttpStatus.CREATED);

    }
    
    
}
