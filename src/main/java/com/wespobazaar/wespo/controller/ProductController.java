package com.wespobazaar.wespo.controller;


import com.wespobazaar.wespo.Repository.CategoryRepo;
import com.wespobazaar.wespo.Repository.SuperCategoryRepo;
import com.wespobazaar.wespo.common.APIResponse;
import com.wespobazaar.wespo.dto.ProductDto;
import com.wespobazaar.wespo.entity.Category;
import com.wespobazaar.wespo.entity.SuperCategory;
import com.wespobazaar.wespo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    SuperCategoryRepo superCategoryRepo;


    @PostMapping("/add")
    public ResponseEntity<APIResponse> createProduct(@RequestBody ProductDto productDto){
        Optional<Category> optionalCategory=categoryRepo.findById(productDto.getCategoryId());
        Optional<SuperCategory> optionalSuperCategory=superCategoryRepo.findById(productDto.getScategoryId());
        if(!optionalCategory.isPresent()) {
            return new ResponseEntity<APIResponse>(new APIResponse(false, "Category and Super does Not Exists"), HttpStatus.NOT_FOUND);
        }
        productService.createProduct(productDto,optionalCategory.get(),optionalSuperCategory.get());
//
//        Category category = optionalCategory.get();
//        productService.addProduct(productDto, category);
        return new ResponseEntity<APIResponse>(new APIResponse(true,"Product Has Been Added"), HttpStatus.CREATED);


    }


    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<ProductDto> body = productService.getallProduct();
       return new ResponseEntity<List<ProductDto>>(body, HttpStatus.OK);

     }
     @GetMapping("/{categoryId}")
     public  ResponseEntity<List<ProductDto>> getProductbyCategoryId(@PathVariable("categoryId")long categoryId) throws Exception{
        List<ProductDto> body=productService.getProductByCategoryId(categoryId);
        return new ResponseEntity<>(body,HttpStatus.OK);
     }

     @GetMapping("/scat/{scat}")
     public ResponseEntity<List<ProductDto>> getProductbySuperCategoryId(@PathVariable("scat")long supercategoryId)throws Exception{

        List<ProductDto> body=productService.getProductBySCatId(supercategoryId);
        return new ResponseEntity<>(body,HttpStatus.OK);
     }



    @PostMapping("/update/{productId}")
    public ResponseEntity<APIResponse> updateProduct(@PathVariable("productId")long productId,@RequestBody ProductDto productDto) throws Exception {
        Optional<Category> optionalCategory=categoryRepo.findById(productDto.getCategoryId());
        if(!optionalCategory.isPresent()) {
            return new ResponseEntity<APIResponse>(new APIResponse(false, "Category does Not Exists"), HttpStatus.NOT_FOUND);
        }
        productService.updateProduct(productDto,productId);
//
//        Category category = optionalCategory.get();
//        productService.addProduct(productDto, category);
        return new ResponseEntity<APIResponse>(new APIResponse(true,"Product Has Been Updated"), HttpStatus.OK);


    }

}
