package com.wespobazaar.wespo.Repository;

import com.wespobazaar.wespo.entity.WishList;
import com.wespobazaar.wespo.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListRepo extends JpaRepository<WishList,Integer> {
     List<WishList> findAllByUserOrderByCreatedDateDesc(User user);
}
