package com.tmdt.handmade.service;

import com.tmdt.handmade.dto.account.UserDTO;
import com.tmdt.handmade.entity.account.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDTO findByEmailWithRoles(String email);

    boolean existsByEmail(String email);

    UserDTO saveOrUpdate(UserDTO userDTO);
}
