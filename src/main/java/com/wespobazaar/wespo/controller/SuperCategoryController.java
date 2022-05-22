package com.wespobazaar.wespo.controller;


import com.wespobazaar.wespo.common.APIResponse;
import com.wespobazaar.wespo.entity.SuperCategory;
import com.wespobazaar.wespo.service.SuperCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/scat")
public class SuperCategoryController {
    @Autowired
    SuperCategoryService superCategoryService;


    @PostMapping("/p")
    public void createsuperCategory(@RequestBody SuperCategory superCategory){
       // Optional<SuperCategory> optionalSuperCategory=superCategoryRepo.findById(productDto.getScategoryId());
        superCategoryService.createSCategory(superCategory);

    }


    @GetMapping("/g")
    public ResponseEntity<List<SuperCategory>> getallsupercategory(){
        List<SuperCategory> list=superCategoryService.getallcategory();
        System.out.println(list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
