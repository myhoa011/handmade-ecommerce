package com.tmdt.handmade.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "color")
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "color_id")
    private int id;

    @Column(name = "color_name")
    private String name;

    @OneToMany
    @JoinColumn(name = "color_id")
    private List<ProductVariant> productVariants = new ArrayList<>();
}
