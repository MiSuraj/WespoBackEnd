package com.wespobazaar.wespo.Repository.userRepo;

import com.wespobazaar.wespo.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
}
