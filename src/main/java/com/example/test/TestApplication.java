package com.example.test;

import com.example.test.domain.AppUser;
import com.example.test.domain.Role;
import com.example.test.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}
	@Bean
	org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner run(UserService userService){
		return args->{
			userService.saveRole(new Role("USER"));
			userService.saveRole(new Role("ADMIN"));

			userService.saveUser(new AppUser("John","john","1234",new ArrayList<>()));
			userService.saveUser(new AppUser("vlad","vlad","1234",new ArrayList<>()));

			userService.addRoleToUser("vlad","ADMIN");
			userService.addRoleToUser("vlad","USER");
			userService.addRoleToUser("john","USER");

		};
	}

}
