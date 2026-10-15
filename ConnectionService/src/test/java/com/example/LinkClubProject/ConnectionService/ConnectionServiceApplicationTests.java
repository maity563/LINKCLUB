package com.example.LinkClubProject.ConnectionService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.LinkClubProject.ConnectionService.entity.Person;
import com.example.LinkClubProject.ConnectionService.repository.Personrepository;

@SpringBootTest
class ConnectionServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired Personrepository prep;

	@Test 
	void postdata(){

		Person p=new Person("Harshu Bhai",25L);
		prep.save(p);

	}

}
