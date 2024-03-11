package com.tmdt.handmade.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "payment_method")
public class PaymentMethod {
    @Id
    @Column(name = "payment_method_id")
    private int id;

    @Column(name = "payment_method_name")
    private String name;
}
