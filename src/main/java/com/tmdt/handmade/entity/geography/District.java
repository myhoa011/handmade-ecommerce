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
@Table(name = "district")
public class District {
    @Id
    @Column(name = "district_id")
    private int id;

    @Column(name = "district_name")
    private String name;

    @Column(name = "city_name")
    private String cityName;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id")
    private List<Ward> wards = new ArrayList<>();
}
