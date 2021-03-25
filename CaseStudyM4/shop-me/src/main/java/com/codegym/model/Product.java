package com.codegym.model;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
@Getter
@Setter
@Entity
@Table(name = "products")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String productName;
    private String image;
    private double price;

    @Where(clause = "delete=false")
    private boolean isDelete = false;

    @ManyToOne
    @JoinColumn(name = "idType", referencedColumnName = "id")
    private ProductType productType;

    public Product() {
    }

    public Product(Integer id, String productName, String image, double price, ProductType productType) {
        this.id = id;
        this.productName = productName;
        this.image = image;
        this.price = price;
        this.productType = productType;
    }
}