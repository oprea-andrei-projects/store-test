package com.example.storetest.service;


import com.example.storetest.exceptions.ItemAlreadyExistsException;
import com.example.storetest.exceptions.NoCategoryFoundException;
import com.example.storetest.exceptions.NoProductsException;
import com.example.storetest.model.Category;
import com.example.storetest.model.Product;
import com.example.storetest.repo.CategoryRepo;
import com.example.storetest.repo.ProductRepo;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StoreService {


   CategoryRepo categoryRepo;
    ProductRepo productRepo;

    public StoreService (CategoryRepo categoryRepo, ProductRepo productRepo){

        this.categoryRepo = categoryRepo;
        this.productRepo = productRepo;
    }

    public List<Product> getAllProducts(){

        List<Product> myProducts = productRepo.findAll();

        if(myProducts.size() == 0){

            throw  new NoProductsException("No products found !!!");
        }

        return myProducts;


    }

    public Product addProduct(Long catId,Product product){

        Optional<Category> categoryOptional = this.categoryRepo.findById(catId);

        if(categoryOptional.isEmpty()){
            throw new NoCategoryFoundException("No category found !!!");
        }

        if(Collections.frequency(categoryOptional.get().getProducts(), product)!=0){

            throw new ItemAlreadyExistsException("Product aleready exists !!!");
        }

        categoryOptional.get().addProducts(product);

        this.productRepo.save(product);

        return product;
    }

   public void deleteProduct(Long catId, Long pId){

       Optional<Category> categoryOptional = this.categoryRepo.findById(catId);
       Optional<Product> productOptional = this.productRepo.findById(pId);
       categoryOptional.get().deleteProductFromCategory(productOptional.get().getId());




       categoryRepo.save(categoryOptional.get());

       categoryOptional.get().getProducts().stream().forEach(System.out::println);


   }


}
