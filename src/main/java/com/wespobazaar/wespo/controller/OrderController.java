package com.wespobazaar.wespo.controller;


import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.wespobazaar.wespo.dto.orderDto.OrderSummaryDto;
import com.wespobazaar.wespo.dto.orderDto.ProductItemsDto;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @PostMapping("/add")
    public String orderItemsSummary(@RequestBody OrderSummaryDto orderSummaryDto) throws RazorpayException {
       List<ProductItemsDto> productItemsDto=orderSummaryDto.getProductsItemsDto();
        System.out.println("Order summary:  "+orderSummaryDto);
        System.out.println("Products : "+orderSummaryDto.getProductsItemsDto());

        for (ProductItemsDto productItem:productItemsDto) {
            System.out.println(" "+productItem);
            //generate order and order id using razor pay

            //



        }
        var razorpayClient = new RazorpayClient("rzp_test_9n03Mfj6HvcRfs", "BwxExQ5UBWZaD4JNQee6BxXq");

        JSONObject options = new JSONObject();
        options.put("amount", 3006);
        options.put("currency", "INR");
        options.put("receipt", "txn_123456");
        Order order = razorpayClient.orders.create(options);
        System.out.println("Order : " +order);
        System.out.println(order.toJson().getString("id"));
//////////If we want to save this to uue database we can do that but first of all we have to integrate the front end now

        return "Created";
    }
}
