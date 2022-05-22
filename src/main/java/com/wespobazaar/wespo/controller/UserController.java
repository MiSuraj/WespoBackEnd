package com.wespobazaar.wespo.controller;

import com.wespobazaar.wespo.dto.userDto.UserDto;
import com.wespobazaar.wespo.entity.user.Role;
import com.wespobazaar.wespo.entity.user.User;
import com.wespobazaar.wespo.entity.user.UserRole;

import com.wespobazaar.wespo.service.userServices.EmailService;
import com.wespobazaar.wespo.service.userServices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private EmailService emailService;
    @Autowired
    private JavaMailSender mailSender;


    //creating User or SignUp
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {
        Set<UserRole> userRoles=new HashSet<>();
        Role role=new Role();
        role.setRoleId(45l);
        role.setRoleName("Normal");

        UserRole userRole=new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        userRoles.add(userRole);
        return this.userService.createUser(user,userRoles);
    }
    @PostMapping("/admin/add")
    public User createAdmin(@RequestBody User user) throws Exception {
        Set<UserRole> userRoles=new HashSet<>();
        Role role=new Role();
        role.setRoleId(45l);
        role.setRoleName("Admin");

        UserRole userRole=new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        userRoles.add(userRole);
        return this.userService.createUser(user,userRoles);
    }

    @PostMapping("/signUp")
    public String userSignUp(@RequestBody User user)throws Exception{
        //password generation and set password to that use
        String password=passwordGenerator();
        user.setPassword(password);
        Set<UserRole> userRoles=new HashSet<>();
        Role role=new Role();
        role.setRoleId(45l);
        role.setRoleName("Normal");

        UserRole userRole=new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        userRoles.add(userRole);
        User user1=this.userService.createUser(user,userRoles);
        if(user1!=null){
            System.out.println("User Created Successfully "+ user1.getUserRoles());
            //email sending process with password
            String toEmail=user1.getEmail();
            String response=emailService.sendmail(user1.getEmail(),password);

            return "USER CREATED !!"+response;







        }
        //storing password and sending that password to that user by their email..



        return null;
    }


    public String passwordGenerator(){
        char ch[]={'a','b','d','D','A','z','Z','K','g','L'};
        char ch2[]={'e','g','f','j','m','N','Q','k','x','T'};
        int number[]={2,5,8,4,3,9,0,6,1,5};
        int n=0;
        String password="";
        for(int i=0;i<2;i++) {
            double m = Math.random();
            n = (int) (m * 10);
            password=password+ch[n]+ch2[n];
        }






        return password+number[n];

    }


}
