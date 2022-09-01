package com.example.storetest.web;


import com.example.storetest.model.Product;
import com.example.storetest.service.StoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin
public class CategoryController {

    private StoreService storeService;

    public CategoryController(StoreService storeService){

        this.storeService = storeService;
    }

    @GetMapping("allProducts")
    public ResponseEntity<List<Product>> alltheProducts(){

        List<Product> allmyProducts = storeService.getAllProducts();

        return new ResponseEntity<>(allmyProducts, HttpStatus.OK);

    }
}
