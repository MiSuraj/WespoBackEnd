package com.wespobazaar.wespo.service.userServices;

import com.wespobazaar.wespo.entity.user.User;
import com.wespobazaar.wespo.entity.user.UserRole;

import java.util.Set;

public interface UserService {
    //creating user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;
    //get user by phone number
    public User getUserEmail(String email);
    public User saveUser(User user);

}
