package com.wespobazaar.wespo.controller;

import com.wespobazaar.wespo.common.APIResponse;
import com.wespobazaar.wespo.entity.user.User;
import com.wespobazaar.wespo.entity.helperClasses.AddToCartDTO;
import com.wespobazaar.wespo.entity.helperClasses.CartDto;
import com.wespobazaar.wespo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    UserDetailsService userDetailsService;

    //Post Cart Api
    @PostMapping("/add")
    public ResponseEntity<APIResponse> addToCart(@RequestBody AddToCartDTO addToCartDTO, @RequestParam("u") String username) {

       String message= cartService.addToCart(addToCartDTO, (User)userDetailsService.loadUserByUsername(username));

           return new ResponseEntity<>(new APIResponse(true,message), HttpStatus.CREATED);
    }


    //get All cart items for a user
    @GetMapping("/")//error
    public ResponseEntity<CartDto> getCartItems(@RequestParam("u") String username){
        //find the user
        User user=(User)userDetailsService.loadUserByUsername(username);
        CartDto cartDto=cartService.listCartItems(user);
        return new ResponseEntity<>(cartDto,HttpStatus.OK);
    }

    //delete a cart items for a user
    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<APIResponse> deleteCartItems(@PathVariable("cartItemId") Long itemId,@RequestParam("u")String username){

        User user=(User)userDetailsService.loadUserByUsername(username);
        cartService.deleteCartItem(itemId,user);
        return new ResponseEntity<>(new APIResponse(true,"Item Deleted"), HttpStatus.CREATED);
    }

}
