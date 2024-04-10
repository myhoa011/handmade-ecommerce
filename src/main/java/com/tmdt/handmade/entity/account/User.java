package com.tmdt.handmade.entity.account;

import com.tmdt.handmade.entity.blog.Blog;
import com.tmdt.handmade.entity.order.Order;
import com.tmdt.handmade.entity.product.Product;
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

    private boolean status;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "role_user",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<AddressDetail> addressDetails = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "seller_id")
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "buyer",
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "user",
    cascade = CascadeType.ALL)
    private List<Blog> blogList = new ArrayList<>();
}
