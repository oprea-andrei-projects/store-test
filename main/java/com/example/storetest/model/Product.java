package com.example.storetest.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name="Product")
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @SequenceGenerator(

            name = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(

            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    Long id;


    @Column(

            name = "sku",
            nullable = false,
            columnDefinition = "TEXT"

    )
    String sku;



    @Column(

            name = "name",
            nullable = false,
            columnDefinition = "TEXT"

    )


    String name;

    @Column(

            name ="price",
            nullable = false,
            columnDefinition = "INTEGER"


    )
    int price ;


    @Column(

            name ="size",
            columnDefinition = "INTEGER"


    )
    int size ;

    @Column(

            name ="weight",
            columnDefinition = "INTEGER"


    )
    int weight ;

    @Column(

            name ="height",
            columnDefinition = "INTEGER"


    )
    int height ;

    @Column(

            name ="width",
            columnDefinition = "INTEGER"


    )
    int width ;

    @Column(

            name ="length",
            columnDefinition = "INTEGER"


    )
    int length;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(
            name="category_id",
            referencedColumnName="id",
            foreignKey = @ForeignKey(
                    name="category_id_fk"
            )
    )
    private Category category;

    public Product(String sku, String name, int price, int size, int weight, int height, int width, int length) {

        this.sku = sku;
        this.name = name;
        this.price = price;
        this.size = size;
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.length = length;

    }

    public Product(Long id){
        this.id =id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", size=" + size +
                ", weight=" + weight +
                ", height=" + height +
                ", width=" + width +
                ", length=" + length +

                '}';
    }
}
