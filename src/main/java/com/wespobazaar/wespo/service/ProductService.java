package com.wespobazaar.wespo.service;


import com.wespobazaar.wespo.Repository.ProductRepo;
import com.wespobazaar.wespo.dto.ProductDto;
import com.wespobazaar.wespo.entity.Category;
import com.wespobazaar.wespo.entity.Product;
import com.wespobazaar.wespo.entity.SuperCategory;
import com.wespobazaar.wespo.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public void createProduct(ProductDto productDto, Category category, SuperCategory superCategory){
            Product product=new Product();
            product.setName(productDto.getName());
            product.setPrice(productDto.getPrice());
            product.setDescription(productDto.getDescription());
            product.setImageUrl1(productDto.getImageUrl1());
            product.setImageUrl2(productDto.getImageUrl2());
            product.setImageUrl3(productDto.getImageUrl3());
            product.setProdUrl(productDto.getProdUrl());
            product.setRating(productDto.getRating());
            product.setCategory(category);
            product.setSuperCategory(superCategory);
            productRepo.save(product);

    }


//    public List<ProductDto> listProducts() {
//        List<Product> products = productRepo.findAll();
//        List<ProductDto> productDtos = new ArrayList<>();
//        for(Product product : products) {
//            ProductDto productDto = getDtoFromProduct(product);
//            productDtos.add(productDto);
//        }
//        return productDtos;
//    }
    public ProductDto getProductDto(Product product){
        ProductDto productDto=new ProductDto();
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());
        productDto.setImageUrl1(product.getImageUrl1());
        productDto.setImageUrl2(product.getImageUrl2());
        productDto.setImageUrl3(product.getImageUrl3());
        productDto.setProdUrl(product.getProdUrl());
        productDto.setRating(product.getRating());
        productDto.setCategoryId(product.getCategory().getId());
        productDto.setId(product.getId());
        productDto.setScategoryId(product.getSuperCategory().getId());
        return productDto;
    }
    public ProductDto getProductDtoCart(Product product){
        ProductDto productDto=new ProductDto();
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());
        productDto.setImageUrl1(product.getImageUrl1());
        productDto.setImageUrl2(product.getImageUrl2());
        productDto.setImageUrl3(product.getImageUrl3());
        productDto.setProdUrl(product.getProdUrl());
        productDto.setRating(product.getRating());
        productDto.setCategoryId(product.getCategory().getId());
        productDto.setId(product.getId());
        productDto.setScategoryId(product.getSuperCategory().getId());

        return productDto;
    }



    public List<ProductDto> getallProduct(){
         List<Product> allProducts=productRepo.findAll();
         List<ProductDto> productDtos=new ArrayList<>();
         for(Product product: allProducts){
             productDtos.add(getProductDto(product));

         }
         return productDtos;
    }

    public List<ProductDto> getProductByCategoryId(long id){
        List<Product> products=productRepo.findAll();
        //wait just wait
        List<ProductDto> product=new ArrayList<>();
        for(Product product1:products){
            if(product1.getCategory().getId()==id){
                product.add(getProductDto(product1));
            }
            else{
                //do nothing
            }
        }
        return product;
    }

    public List<ProductDto> getProductBySCatId(long id){

        List<Product> products=productRepo.findAll();
        //wait just wait
        List<ProductDto> product=new ArrayList<>();
        for(Product product1:products){
            if(product1.getSuperCategory().getId()==id){
                product.add(getProductDto(product1));
            }
            else{
                //do nothing
            }
        }
        return product;
    }

    public void updateProduct(ProductDto productDto,long productID) throws Exception {
       Optional<Product> optionalproduct= productRepo.findById(productID);
       //throw exception if product does not exists
        if(!optionalproduct.isPresent()){
            throw new Exception("Product is not Present");

        }
        Product product=optionalproduct.get();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setImageUrl1(productDto.getImageUrl1());
        product.setImageUrl2(productDto.getImageUrl2());
        product.setImageUrl3(productDto.getImageUrl3());
        product.setProdUrl(productDto.getProdUrl());
        product.setRating(productDto.getRating());
        productRepo.save(product);

    }

    public Product findById(Long id) {

       Optional<Product> product= productRepo.findById(id);
        if(product.isEmpty()){
            throw new ProductNotFoundException("Product is Invalid "+id);
        }
        return product.get();
    }
}
