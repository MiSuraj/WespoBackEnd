package com.wespobazaar.wespo.service;

import com.wespobazaar.wespo.Repository.WishListRepo;
import com.wespobazaar.wespo.dto.ProductDto;
import com.wespobazaar.wespo.entity.WishList;
import com.wespobazaar.wespo.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishListService {
    @Autowired
    WishListRepo wishListRepo;
    @Autowired
    ProductService productService;

    public void createList(WishList wishList) {
        wishListRepo.save(wishList);
    }

    public List<ProductDto> getWishListForUser(User user1) {
        List<WishList> wishLists = wishListRepo.findAllByUserOrderByCreatedDateDesc(user1);
        List<ProductDto> productDtos = new ArrayList<>();
        for (WishList wishList : wishLists) {
            productDtos.add(productService.getProductDto(wishList.getProduct()));
        }
        return productDtos;
    }
}
