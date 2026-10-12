package com.example.LinkClubProject.userService.utils;

import org.mindrot.jbcrypt.BCrypt;

public class Bcrypt {

    public static String hash(String password){

        String hashedpassword=BCrypt.hashpw(password,BCrypt.gensalt(12));

        return hashedpassword;
    }

    public static boolean checkpassword(String password,String hashedpassword){

        if(BCrypt.checkpw(password, hashedpassword)){
            return true;
        }

        return false;
    }
    
}
