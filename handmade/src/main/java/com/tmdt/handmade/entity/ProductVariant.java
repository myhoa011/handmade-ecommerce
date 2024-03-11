package com.tmdt.handmade.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "product_variant")
public class ProductVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_variant_id")
    private int id;

    @Column(name = "stock_quantity")
    private int stockQuantity;

}
