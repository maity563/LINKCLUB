package com.example.LinkClubProject.posts_service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.LinkClubProject.posts_service.dto.PersonDto;

@FeignClient(name="ConnectionService",path="/connections")
public interface ConnectionServiceClient {

    @GetMapping("/{userId}/first-degree-users")
    List<PersonDto> getFirstDegreeConnections(@PathVariable Long userId);    

}
