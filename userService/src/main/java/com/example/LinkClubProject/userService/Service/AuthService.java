package com.example.LinkClubProject.userService.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LinkClubProject.userService.DTO.LoginRequestDTO;
import com.example.LinkClubProject.userService.DTO.SignUpRequestDTO;
import com.example.LinkClubProject.userService.DTO.UserDTO;
import com.example.LinkClubProject.userService.Entity.User;
import com.example.LinkClubProject.userService.Exception.BadRequestException;
import com.example.LinkClubProject.userService.Repository.UserRepository;
import com.example.LinkClubProject.userService.utils.Bcrypt;

@Service 
public class AuthService {

    @Autowired ModelMapper modelMapper;
    @Autowired UserRepository userrep;
    @Autowired JwtService jwtService;

    public UserDTO signup(SignUpRequestDTO signUpRequestDTO){

        boolean exists=userrep.existsByEmail(signUpRequestDTO.getEmail());

        if(exists){
            throw new BadRequestException("The email "+signUpRequestDTO.getEmail()+" already exists.");
        }

        User user=modelMapper.map(signUpRequestDTO, User.class);

        user.setEmail(signUpRequestDTO.getEmail());
        user.setPassword(Bcrypt.hash(signUpRequestDTO.getPassword()));

        userrep.save(user);

        return modelMapper.map(user,UserDTO.class);

    } 

    public String login(LoginRequestDTO loginRequestDTO){

        boolean exists=userrep.existsByEmail(loginRequestDTO.getEmail());

        if(!exists){
            throw new BadRequestException("The email "+loginRequestDTO.getEmail()+" does not exist.");
        }
        
        User user=userrep.findByEmail(loginRequestDTO.getEmail()).getLast();

        

        boolean checkpassword=Bcrypt.checkpassword(loginRequestDTO.getPassword(),user.getPassword());

        if(!checkpassword){
            throw new BadRequestException("The password entered is incorrect");
        }
        

       return jwtService.generatetoken(user);

    }
    
    
}
