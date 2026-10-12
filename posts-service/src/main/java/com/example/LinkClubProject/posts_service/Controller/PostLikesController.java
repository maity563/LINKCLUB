package com.example.LinkClubProject.posts_service.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.LinkClubProject.posts_service.Service.PostLikeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController 
@RequestMapping ("/likes")
public class PostLikesController {

    @Autowired PostLikeService postlikeservice;

    @PostMapping("/{postId}")
    public ResponseEntity<?> postlike(@PathVariable Long postId) {
        
        postlikeservice.likepost(postId);
        return new ResponseEntity<>("Like Done",HttpStatus.CREATED);
    }

    @DeleteMapping("/unlike/{postId}")
    public ResponseEntity<?> postunlike(@PathVariable Long postId){

        postlikeservice.unlikepost(postId);

        return new ResponseEntity<>("Unlike Done",HttpStatus.CREATED);
    } 
    
    
}
