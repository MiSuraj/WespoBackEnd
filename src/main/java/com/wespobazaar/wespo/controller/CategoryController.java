package com.wespobazaar.wespo.controller;


import com.wespobazaar.wespo.Repository.SuperCategoryRepo;
import com.wespobazaar.wespo.common.APIResponse;
import com.wespobazaar.wespo.dto.CategoryDto;
import com.wespobazaar.wespo.entity.Category;
import com.wespobazaar.wespo.entity.SuperCategory;
import com.wespobazaar.wespo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    SuperCategoryRepo superCategoryRepo;



    @PostMapping("/create")
    public ResponseEntity<APIResponse> createCategory(@RequestBody CategoryDto categoryDto) {
        Optional<SuperCategory> optionalSuperCategory=superCategoryRepo.findById(categoryDto.getScategoryId());
          if(optionalSuperCategory.isPresent()){
              categoryService.createCategory(categoryDto,optionalSuperCategory.get());
            return new ResponseEntity<>(new APIResponse(true, "created!! a new category"), HttpStatus.CREATED);
        }

        else {
            return new ResponseEntity<>(new APIResponse(false, "Not Found Super Category"), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<CategoryDto>> listCategory(){
        List<CategoryDto> body = categoryService.listallcategory();
        return new ResponseEntity<List<CategoryDto>>(body, HttpStatus.OK);

    }


    @PostMapping("/update/{categoryId}")
    public ResponseEntity<APIResponse> UpdateCategory(@PathVariable("categoryId") long categoryId,@RequestBody Category category){

        if(!categoryService.findById(categoryId)) {
            return new ResponseEntity<>(new APIResponse(false, "Category Not Found"), HttpStatus.NOT_FOUND);

        }


            categoryService.editCategory(categoryId, category);


            return new ResponseEntity<>(new APIResponse(true, "Category has been updated"), HttpStatus.OK);

    }






}
