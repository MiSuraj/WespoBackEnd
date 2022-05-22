package com.wespobazaar.wespo.Repository;

import com.wespobazaar.wespo.entity.Cart;
import com.wespobazaar.wespo.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepo extends JpaRepository<Cart,Long> {
    List<Cart> findAllByUserOrderByCreatedDateDesc(User user);
    @Query(value = "select product_id from cart e where e.product_id = ?1 and e.user_id=?2" , nativeQuery = true)
    Long findByProductId(Long productId,Long userId);
}
