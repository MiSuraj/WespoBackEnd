package com.wespobazaar.wespo.service;

import com.wespobazaar.wespo.Repository.CartRepo;
import com.wespobazaar.wespo.entity.Cart;
import com.wespobazaar.wespo.entity.Product;
import com.wespobazaar.wespo.entity.user.User;
import com.wespobazaar.wespo.exceptions.CustomException;
import com.wespobazaar.wespo.entity.helperClasses.AddToCartDTO;
import com.wespobazaar.wespo.entity.helperClasses.CartDto;
import com.wespobazaar.wespo.entity.helperClasses.CartItemsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private ProductService productService;
    public String addToCart(AddToCartDTO addToCartDTO, User user) {

        String message = "Product is already added to your cart ";
        //validate product id

        Product product = productService.findById(addToCartDTO.getProductId());
        //Creating cart object and saving the cart


        if (cartRepo.findByProductId(addToCartDTO.getProductId(), user.getId()) != addToCartDTO.getProductId())
        {
            Cart cart = new Cart();
            cart.setProduct(product);
            cart.setUser(user);
            cart.setQuantity(addToCartDTO.getQuantity());
            cart.setCreatedDate(new Date());

            cartRepo.save(cart);
            return "Product added successfully!!!";
    }
  return message;



    }

    public CartDto listCartItems(User user) {
         List<Cart> cartList=cartRepo.findAllByUserOrderByCreatedDateDesc(user);
         List<CartItemsDto> cartItems=new ArrayList<>();
        double totalCost=0;
         for(Cart cart :cartList){

            Product p=cart.getProduct();
            p.setCategory(null);//I apply this logic because there is a circular dependency in category superCategory and product section
            p.setSuperCategory(null);
            cart.setProduct(p);

             CartItemsDto cartItemsDto=new CartItemsDto(cart);
             totalCost+=cartItemsDto.getQuantity()*cart.getProduct().getPrice();
             cartItems.add(cartItemsDto);
         }
         CartDto cartDto=new CartDto();
         cartDto.setTotalCost(totalCost);
         cartDto.setCartItems(cartItems);
         return cartDto;
    }

    public void deleteCartItem(Long itemId, User user)  {
       //Item id belong to user
        Optional<Cart> optionalCart=cartRepo.findById(itemId);
        if(optionalCart.isEmpty()){
            throw new CustomException("Cart item id is invalid "+itemId);

        }
        Cart cart=optionalCart.get();
        if(cart.getUser()!=user){
            throw new CustomException("cart item does not belong to user " +itemId);

        }
        cartRepo.delete(cart);

    }
}
