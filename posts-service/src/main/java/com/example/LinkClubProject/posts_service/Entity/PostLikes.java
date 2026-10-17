package com.example.LinkClubProject.posts_service.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Getter 
@Setter 
@Builder
@AllArgsConstructor
@NoArgsConstructor 
public class PostLikes {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userid;

    @Column(nullable=false)
    private Long postid;


    @CreationTimestamp 
    private LocalDateTime localDateTime;

    /*public  PostLikes(Long userid,Long postid)
    {
        this.postid=postid;
        this.userid=userid;

    }*/
}
