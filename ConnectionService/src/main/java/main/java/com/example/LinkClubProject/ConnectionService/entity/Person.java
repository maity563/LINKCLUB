package main.java.com.example.LinkClubProject.ConnectionService.entity;

import org.springframework.data.neo4j.core.schema.Node;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Node
@Data   
@Getter 
@Setter 
@NoArgsConstructor 
public class Person {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userid;

    private String name;
    
}
