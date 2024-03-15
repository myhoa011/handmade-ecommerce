package com.tmdt.handmade.service;

import com.tmdt.handmade.entity.account.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByEmail(String email);
}
