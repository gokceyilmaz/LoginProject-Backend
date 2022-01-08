package com.example.LoginProject;

import com.example.LoginProject.domain.Role;
import com.example.LoginProject.domain.User;
import com.example.LoginProject.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class LoginProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginProjectApplication.class, args);
	}
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
	return args -> {
		userService.saveRole(new Role(null,"ROLE_USER"));
		userService.saveRole(new Role(null,"ROLE_MANAGER"));
		userService.saveRole(new Role(null,"ROLE_ADMIN"));
		userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

		userService.saveUser(new User(null,"Gökçe Yılmaz","gokceyilmaz","1234",new ArrayList<>()));
		userService.saveUser(new User(null,"Mert Ali","mert","1234",new ArrayList<>()));
		userService.saveUser(new User(null,"Burak Karakoyun","burak","1234",new ArrayList<>()));
		userService.saveUser(new User(null,"Rüzgar Karayel","ruzgar","1234",new ArrayList<>()));

		userService.addRoleToUser("mert","ROLE_USER");
		userService.addRoleToUser("burak","ROLE_MANAGER");
		userService.addRoleToUser("ruzgar","ROLE_MANAGER");
		userService.addRoleToUser("burak","ROLE_ADMIN");
		userService.addRoleToUser("gokceyilmaz","ROLE_SUPER_ADMIN");
		userService.addRoleToUser("gokceyilmaz","ROLE_ADMIN");
		userService.addRoleToUser("gokceyilmaz","ROLE_USER");

		};
	}

}
