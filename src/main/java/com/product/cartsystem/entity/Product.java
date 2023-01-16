package com.product.cartsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "product_size")
    private String productSize;

    @Column(name = "price")
    private int price;

   /* @Column(name = "brand_id")
    private int brandId;

    @Column(name = "color_id")
    private int colorId;

    @Column(name = "category_id")
    private int categoryId;*/

    @JsonIgnoreProperties("products")
    //@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", insertable = false, updatable = false)
    private Brand brand;

    @JsonIgnoreProperties("products")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "color_id", insertable = false, updatable = false)
    private Color color;

    @JsonIgnoreProperties("products")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private ProductCategory category;
}
