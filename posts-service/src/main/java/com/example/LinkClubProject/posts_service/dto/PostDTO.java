package com.example.LinkClubProject.posts_service.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data 
@Getter 
@Setter 
public class PostDTO {

    private Long id;

    private String content;

    private Long userid;

    private LocalDateTime createdAt;
    
}
