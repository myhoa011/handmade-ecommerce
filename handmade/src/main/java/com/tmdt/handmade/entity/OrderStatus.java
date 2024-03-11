package com.tmdt.handmade.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "order_status")
public class OrderStatus {
    @Id
    @Column(name = "order_status_id")
    private int id;
    @Column(name = "order_status_name")
    private String name;
}
