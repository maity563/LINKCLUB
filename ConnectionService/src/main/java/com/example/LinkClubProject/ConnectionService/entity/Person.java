package com.example.LinkClubProject.ConnectionService.entity;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Node("Person")
@Data   
@Getter 
@Setter 
public class Person {

    @Id 
    @GeneratedValue 
    private Long id;

    private Long userid;

    private String name;

    public Person(String name,Long userid){
        this.name=name;
        this.userid=userid;
    }
    
}
