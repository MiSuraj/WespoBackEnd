package com.wespobazaar.wespo.service;

import com.wespobazaar.wespo.Repository.SuperCategoryRepo;
import com.wespobazaar.wespo.entity.SuperCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperCategoryService {

    @Autowired
    SuperCategoryRepo superCategoryRepo;

    public void createSCategory(SuperCategory superCategory) {

        superCategoryRepo.save(superCategory);

    }
    public List<SuperCategory> getallcategory(){
       return superCategoryRepo.findAll();
    }
}
