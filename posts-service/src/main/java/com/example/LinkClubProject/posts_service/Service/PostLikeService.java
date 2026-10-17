package com.example.LinkClubProject.posts_service.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.LinkClubProject.posts_service.Entity.Post;
import com.example.LinkClubProject.posts_service.Entity.PostLikes;
import com.example.LinkClubProject.posts_service.Exception.BadRequestException;
import com.example.LinkClubProject.posts_service.Exception.ResourceNotFoundException;
import com.example.LinkClubProject.posts_service.Repository.PostLikeRepository;
import com.example.LinkClubProject.posts_service.Repository.PostRepository;

@Service 
public class PostLikeService {

    @Autowired PostRepository postrep;
    @Autowired PostLikeRepository postlikerep;

    @Transactional
    public void likepost(Long postId){
        Long userid=1L;

        Post post=postrep.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post is not Found with Post id = "+postId));
        
        boolean exists=postlikerep.existsByUseridAndPostid(userid, postId);

        if(exists){
            throw new BadRequestException("Cannot Like the post again");
        }
       
        PostLikes postLikes=PostLikes.builder().userid(userid).postid(postId).build();

        postlikerep.save(postLikes);     
        
        // send notifications to user using Kafka Later

    }


          @Transactional 
         public void unlikepost(Long postid){

            Long userid=1L;
 
                    Post post=postrep.findById(postid).orElseThrow(()-> new ResourceNotFoundException("Post is not Found with Post id = "+postid));

             boolean exists=postlikerep.existsByUseridAndPostid(userid, postid);

        if(!exists){
            throw new BadRequestException("Like for the post does not exist by the user,so can't unlike");

        }       

         postlikerep.deleteByUseridAndPostid(userid, postid);
             
         }


    
}
