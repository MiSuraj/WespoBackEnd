package com.wespobazaar.wespo.Repository.userRepo;

import com.wespobazaar.wespo.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    public User findByPhone(String phone);
    public User findByEmail(String email);
}
