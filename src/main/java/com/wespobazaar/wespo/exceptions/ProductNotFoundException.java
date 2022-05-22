package com.wespobazaar.wespo.exceptions;

public class ProductNotFoundException extends IllegalArgumentException {
    public ProductNotFoundException(String msg) {
   super(msg);
    }
}
