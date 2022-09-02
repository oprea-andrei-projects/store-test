package com.example.storetest.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Category")
@Table(name = "category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {


    @Id
    @SequenceGenerator(

            name = "category_sequence",
            allocationSize = 1
    )
    @GeneratedValue(

            strategy = GenerationType.SEQUENCE,
            generator = "category_sequence"
    )
    Long id;

    @Column(

            name ="code",
            nullable = false,
            columnDefinition = "INTEGER"


    )
    int code ;


    @Column(

            name = "description",
            nullable = false,
            columnDefinition = "TEXT"

    )

    String description;





    @JsonManagedReference
    @OneToMany(
            mappedBy = "category",
            cascade = {CascadeType.ALL},
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    private List<Product> products = new ArrayList<>();



    public Category(int code, String description) {

        this.code = code;
        this.description = description;

    }

    public void addProducts(Product product){

        this.products.add(product);
        product.setCategory(this);

    }

    public void deleteProductFromCategory(Long prodID){
        this.getProducts().remove(new Product(prodID));

    }


}
