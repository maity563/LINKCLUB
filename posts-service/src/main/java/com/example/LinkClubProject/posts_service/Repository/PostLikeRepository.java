package com.example.LinkClubProject.posts_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LinkClubProject.posts_service.Entity.PostLikes;

public interface PostLikeRepository extends JpaRepository<PostLikes,Long> {

    boolean existsByUseridAndPostid(Long userid,Long postid);

    void deleteByUseridAndPostid(Long userid,Long postid);
}
