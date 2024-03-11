package com.tmdt.handmade.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "stock_quantity")
    private int stockQuantity;

    private BigDecimal price;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<Review> reviews = new ArrayList<>();
}
