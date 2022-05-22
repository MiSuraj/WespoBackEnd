package com.wespobazaar.wespo;

import com.wespobazaar.wespo.entity.user.Role;
import com.wespobazaar.wespo.entity.user.User;
import com.wespobazaar.wespo.entity.user.UserRole;
import com.wespobazaar.wespo.service.userServices.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class WespoApplication implements CommandLineRunner {

	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(WespoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		User user =new User();
//
//		user.setname("Ashish Kumar");
//		user.setPhone("8081655187");
//		user.setPassword(bCryptPasswordEncoder.encode("abcde"));
//		user.setEmail("ashish.kumar@gmail.com");
//		user.setProfile("default.png");
//
//		Role role1=new Role();
//		role1.setRoleId(5);
//		role1.setRoleName("Admin");
//
//		Set<UserRole> userRoleSet=new HashSet<>();
//		UserRole userRole=new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//		userRoleSet.add(userRole);
//
//		User user1=this.userService.createUser(user,userRoleSet);


	}



}
