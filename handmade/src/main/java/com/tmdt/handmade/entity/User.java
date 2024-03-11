package com.tmdt.handmade.entity;

import com.tmdt.handmade.entity.geography.AddressDetail;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(updatable = false, unique = true, nullable = false)
    private String email;

    private String password;

    @Column(name = "full_name")
    private String fullName;

    private boolean gender;

    private LocalDate dob;

    private BigDecimal balance;

    private int status;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "role_user",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<AddressDetail> addressDetails = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "seller_id")
    private List<Product> products = new ArrayList<>();
}
