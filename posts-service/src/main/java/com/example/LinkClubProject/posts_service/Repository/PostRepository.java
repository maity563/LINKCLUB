package com.example.LinkClubProject.posts_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LinkClubProject.posts_service.Entity.Post;
import java.util.List;


@Repository 
public interface PostRepository  extends JpaRepository<Post,Long>{

     List<Post> findByUserid(Long userid);

}
