package com.tmdt.handmade.entity.geography;

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
@Table(name = "ward")
public class Ward {
    @Id
    @Column(name = "ward_id")
    private int id;

    @Column(name = "ward_name")
    private String name;

    @OneToMany
    @JoinColumn(name = "ward_id")
    private List<AddressDetail>  addressDetails = new ArrayList<>();
}
