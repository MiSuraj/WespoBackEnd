package com.wespobazaar.wespo.service;


import com.wespobazaar.wespo.Repository.CategoryRepo;
import com.wespobazaar.wespo.Repository.SuperCategoryRepo;
import com.wespobazaar.wespo.dto.CategoryDto;
import com.wespobazaar.wespo.dto.ProductDto;
import com.wespobazaar.wespo.entity.Category;

import com.wespobazaar.wespo.entity.Product;
import com.wespobazaar.wespo.entity.SuperCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {



    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    SuperCategoryRepo superCategoryRepo;


    public void createCategory(CategoryDto categoryDto, SuperCategory superCategory) {
        Category category=new Category();
        category.setCategoryName(categoryDto.getCategoryName());
        category.setDescription(categoryDto.getDescription());
        category.setImageUrl(categoryDto.getImageUrl());
        category.setId(categoryDto.getId());
        category.setSuperCategory(superCategory);

            categoryRepo.save(category);


    }
    public CategoryDto getCategoryDto(Category category){

        CategoryDto categoryDto=new CategoryDto();

        categoryDto.setCategoryName(category.getCategoryName());
        categoryDto.setImageUrl(category.getImageUrl());
        categoryDto.setDescription(category.getDescription());
       categoryDto.setScategoryId(category.getSuperCategory().getId());
       categoryDto.setId(category.getId());
     return categoryDto;
    }
    public List<CategoryDto> listallcategory() {
        List<Category> categoryList=categoryRepo.findAll();
        List<CategoryDto> categoryDtos=new ArrayList<>();
        for(Category category: categoryList){
            categoryDtos.add(getCategoryDto(category));

        }
        return categoryDtos;

    }

    public void editCategory(long categoryId,Category updatecategory){
        Category category=categoryRepo.getById(categoryId);
        category.setCategoryName(updatecategory.getCategoryName());
        category.setDescription(updatecategory.getDescription());
        category.setImageUrl(updatecategory.getImageUrl());
        categoryRepo.save(category);
    }

    public boolean findById(long categoryId){
        return categoryRepo.findById(categoryId).isPresent();
    }
}
