package com.wespobazaar.wespo.service.userServices;

import com.wespobazaar.wespo.Repository.userRepo.RoleRepo;
import com.wespobazaar.wespo.Repository.userRepo.UserRepo;
import com.wespobazaar.wespo.entity.user.User;
import com.wespobazaar.wespo.entity.user.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService{
     @Autowired
    private UserRepo userRepo;
     @Autowired
     private RoleRepo roleRepo;
     @Autowired
     private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public User createUser(User user, Set<UserRole> userRoles)throws Exception {
             User local;
//what if phone or email is null this problem need to be solve as soon as possible

           if(this.userRepo.findByEmail(user.getEmail())!=null||this.userRepo.findByPhone(user.getPhone()) !=null)
           {
               System.out.println("User already Present With This Phone or Email");
               throw new Exception("User is already Present With This Phone or Email");

           }
           else{
               //create User
               for(UserRole ur:userRoles){
                   roleRepo.save(ur.getRole());
                   
               }
               user.getUserRoles().addAll(userRoles);
               user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
                 local=this.userRepo.save(user);

           }
        return local;
    }

    @Override
    public User getUserEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }
    //getting user by username

}
