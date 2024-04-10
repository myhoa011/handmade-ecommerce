package com.tmdt.handmade.dto.account;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoleDTO {
    private int id;

    private String name;

    private String description;
}
