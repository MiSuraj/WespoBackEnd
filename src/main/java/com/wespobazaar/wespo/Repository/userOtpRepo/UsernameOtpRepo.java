package com.wespobazaar.wespo.Repository.userOtpRepo;

import com.wespobazaar.wespo.entity.UserOtp.UsernameOtp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsernameOtpRepo extends JpaRepository<UsernameOtp,Long> {
    @Query(value = "select * from username_otp e where e.username = ?1", nativeQuery = true)
    public UsernameOtp findUsername(String username);

}
