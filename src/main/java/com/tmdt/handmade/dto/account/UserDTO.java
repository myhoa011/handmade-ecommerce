package com.tmdt.handmade.dto.account;

import com.tmdt.handmade.entity.account.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
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
public class UserDTO {
    private int id;
    @Email
    @NotEmpty(message = "Email should not be null or empty")
    private String email;
    @NotEmpty(message = "Password should not be null or empty")
    private String password;
    @NotEmpty(message = "Your name should not be null or empty")
    private String fullName;

    private boolean gender;

    private LocalDate dob;

    private BigDecimal balance;

    private boolean status;

    //Danh sách chức vụ của user
    private List<Integer> roleIdList = new ArrayList<>();

}
