package com.wespobazaar.wespo.controller;

import com.wespobazaar.wespo.common.APIResponse;
import com.wespobazaar.wespo.dto.ProductDto;
import com.wespobazaar.wespo.entity.Product;
import com.wespobazaar.wespo.entity.WishList;
import com.wespobazaar.wespo.entity.user.User;
import com.wespobazaar.wespo.service.ProductService;
import com.wespobazaar.wespo.service.WishListService;
import com.wespobazaar.wespo.service.userServices.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")//After Login so it needs to be validate need to be Authenticated
public class WishListController {
    @Autowired
    WishListService wishListService;
    @Autowired
    UserDetailsServiceImpl userDetailsService;


    //post/save  Product in Wish List
    @PostMapping("/add")
    public ResponseEntity<APIResponse> addToWishList(@RequestBody Product product,
                                                     @RequestParam("username") String username
                                                        ){

        System.out.println(username);
        //find the user
        User user= (User) userDetailsService.loadUserByUsername(username);
        WishList wishList=new WishList(user,product);
        wishListService.createList(wishList);
        APIResponse apiResponse=new APIResponse(true,"Added To Wishlist");
        return  new ResponseEntity<>(apiResponse, HttpStatus.CREATED);

        //save the item in wishlist
    }


    //get All wishlist from the wishlist
    @GetMapping("/get")
    public ResponseEntity<List<ProductDto>> getWishList(@RequestParam("u") String username){

        User user1=(User)userDetailsService.loadUserByUsername(username);
        List<ProductDto> productDtos=  wishListService.getWishListForUser(user1);
   return new ResponseEntity<>(productDtos,HttpStatus.OK);
    }

}
