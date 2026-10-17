package com.example.LinkClubProject.userService.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data 
@Getter 
@Setter
@NoArgsConstructor 
@Builder 
@AllArgsConstructor 
public class SignUpRequestDTO {

    private String name;
    private String email;
    private String password; 
    
}
