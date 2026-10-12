package com.example.LinkClubProject.posts_service.Service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LinkClubProject.posts_service.Entity.Post;
import com.example.LinkClubProject.posts_service.Exception.ResourceNotFoundException;
import com.example.LinkClubProject.posts_service.Repository.PostRepository;
import com.example.LinkClubProject.posts_service.dto.PostCreateRequestDTO;
import com.example.LinkClubProject.posts_service.dto.PostDTO;

@Service 
public class PostService {

    @Autowired private ModelMapper modelMapper;
    @Autowired private PostRepository postrepo;

    public PostDTO createPost(PostCreateRequestDTO postCreateRequestDTO,Long userid){

        Post post=modelMapper.map(postCreateRequestDTO, Post.class);

        post.setUserid(userid);

        postrepo.save(post);

        PostDTO postDTO=modelMapper.map(post,PostDTO.class);

        return postDTO;
    }


    public PostDTO  getbyPostid(Long postid){
        Post p= postrepo.findById(postid).orElseThrow(()-> new ResourceNotFoundException("Post not Found with post Id = "+postid));

        PostDTO postDTO=modelMapper.map(p, PostDTO.class);

        return postDTO;

    }

    public List<PostDTO> getallpostsbyuser(Long userid){
        
        List<Post> p=postrepo.findByUserid(userid);

        List<PostDTO> p1=new ArrayList<>();

        for(Post p2:p){
            PostDTO p3=modelMapper.map(p2,PostDTO.class);
            p1.add(p3);
        }

        return p1;
    }


    

    
}
