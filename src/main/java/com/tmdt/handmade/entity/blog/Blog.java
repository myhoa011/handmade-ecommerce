package com.tmdt.handmade.entity.blog;

import com.tmdt.handmade.entity.account.User;
import com.tmdt.handmade.entity.geography.AddressDetail;
import com.tmdt.handmade.entity.product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate dateCreated;

    private String Title;

    private String Body;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "blog",
            cascade = CascadeType.ALL)
    private List<BlogComment> blogCommentList = new ArrayList<>();
}
