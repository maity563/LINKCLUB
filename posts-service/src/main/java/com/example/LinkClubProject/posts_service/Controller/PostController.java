package com.example.LinkClubProject.posts_service.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LinkClubProject.posts_service.Service.PostService;
import com.example.LinkClubProject.posts_service.auth.AuthContextHolder;
import com.example.LinkClubProject.posts_service.dto.PostCreateRequestDTO;
import com.example.LinkClubProject.posts_service.dto.PostDTO;

import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController 
@RequestMapping ("/core")
public class PostController {
    

    @Autowired  PostService postservice;
    @PostMapping("")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostCreateRequestDTO postCreateRequestDTO,HttpServletResponse response){
        
         PostDTO postDTO=postservice.createPost(postCreateRequestDTO,1L);

         return new ResponseEntity<>(postDTO,HttpStatus.CREATED);

    }


    @GetMapping("/{postid}")
    public ResponseEntity<PostDTO> getPosts(@PathVariable  Long postid)
    {
         Long userid=AuthContextHolder.getuserId();
         PostDTO postDTO=postservice.getbyPostid(postid);
         
         return new ResponseEntity<>(postDTO,HttpStatus.OK);
    }


    @GetMapping("/users/{userid}/getallposts")
    public ResponseEntity<List<PostDTO>> getallposts(@PathVariable Long userid) {
        List<PostDTO> p=postservice.getallpostsbyuser(userid);

        return new ResponseEntity<>(p,HttpStatus.OK);
    }
    
    

}
