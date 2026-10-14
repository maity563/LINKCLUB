package main.java.com.example.LinkClubProject.ConnectionService.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import main.java.com.example.LinkClubProject.ConnectionService.entity.Person;
import java.util.List;
import java.util.Optional;


@Repository 
public interface Personrepository extends Neo4jRepository<Person,Long> {

    Optional<Person> findByUserid(Long userid);


    @Query("match (personA: Person) -[: CONNECTED_TO] - (personB:Person) where PersonA.userId=2  return personB; ")
    List<Person> firstdegrePersons(Long userId);
}
