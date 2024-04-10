package com.tmdt.handmade.service.impl;

import com.tmdt.handmade.dto.account.UserDTO;
import com.tmdt.handmade.entity.account.User;
import com.tmdt.handmade.repository.UserRepository;
import com.tmdt.handmade.security.SecurityConfig;
import com.tmdt.handmade.service.UserService;
import com.tmdt.handmade.security.SecurityConfig;
import com.tmdt.handmade.util.EncodePassword;
import com.tmdt.handmade.util.converter.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserConverter userConverter;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    public UserDTO findByEmailWithRoles(String email) {
        User user = userRepository.findByEmailWithRoles(email);
        if(user==null)
            return null;
        return userConverter.toDTO(user);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public UserDTO saveOrUpdate(UserDTO userDTO) {
        User user = userConverter.toEnity(userDTO);
        user.setStatus(true);
        user.setPassword(EncodePassword.passwordEncoder().encode(user.getPassword().trim()));
        user = userRepository.save(user);
        return userConverter.toDTO(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmailWithRoles(email);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid email or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                user.getRoles().stream()
                        .map((role) -> new SimpleGrantedAuthority(role.getName()))
                        .collect(Collectors.toList()));
    }

}
