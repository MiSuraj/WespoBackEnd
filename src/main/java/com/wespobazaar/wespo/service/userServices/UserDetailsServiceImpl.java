package com.wespobazaar.wespo.service.userServices;

import com.wespobazaar.wespo.Repository.userRepo.UserRepo;
import com.wespobazaar.wespo.entity.user.User;
import com.wespobazaar.wespo.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       //implementation of fetching User
        //user not found or found 24
        User user= user=userRepo.findByEmail(username);;
        try {
            System.out.println("User Detail Service IMPL");
            if (username.contains("@")) {
                System.out.println("This is Email Calling " + username);

                System.out.println("user detail service "+ user.getUsername());
                return user;

            }
            else if (username.length() == 10 || Integer.parseInt(username.substring(0, 5)) < 99999) {
                System.out.println("This Is Phone Number " + username);
                 user=userRepo.findByPhone(username);
                System.out.println("user detail service phone "+ user.getUsername());
                return user;
            }


            //if User has Email
        }
        catch (UsernameNotFoundException e)
        {
           //Exception Caught
            System.out.println("User Not Found ");
        }
        System.out.println("user detail service "+ user.getUsername());

        return user;
    }

}
