package com.example.tech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TechApplication implements CommandLineRunner{

	@Autowired
	UserDAOService service;
	public static void main(String[] args) {
		SpringApplication.run(TechApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//User user = new User("Jack","Admin","Test@gmail.com");
		//long i = service.insert(user);
		//System.out.println("Id inserted is ---> "+ i);
		
		
	}

}
