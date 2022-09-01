package com.example.storetest;

import com.example.storetest.model.Category;
import com.example.storetest.model.Product;
import com.example.storetest.repo.CategoryRepo;
import com.example.storetest.service.StoreService;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StoreTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreTestApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(StoreService storeService){

        return args -> {

//            Faker faker = new Faker();
//
//            for (int i = 0; i < 3; i++) {
//
//                Category category = new Category(i+1,"description"+i);
//
//                for(int j=0; j<2; j++){
//
//                    category.addProducts(new Product((i+1)+faker.code().asin(),
//                            faker.name().title(),faker.number().randomDigit(),faker.number().randomDigit(),
//                            faker.number().randomDigit(),faker.number().randomDigit(),faker.number().randomDigit(),faker.number().randomDigit()));
//                }
//
//                categoryRepo.save(category);
//
//            }
//            storeService.getAllProducts().stream().forEach(System.out::println);

            storeService.deleteProduct(7L,32L);



        };
    }
}
