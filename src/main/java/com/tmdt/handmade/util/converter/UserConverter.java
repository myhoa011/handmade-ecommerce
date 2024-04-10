package com.tmdt.handmade.util.converter;

import com.tmdt.handmade.dto.account.RoleDTO;
import com.tmdt.handmade.dto.account.UserDTO;
import com.tmdt.handmade.entity.account.Role;
import com.tmdt.handmade.entity.account.User;
import com.tmdt.handmade.repository.RoleRepository;
import com.tmdt.handmade.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class UserConverter {
    private final ModelMapper modelMapper;

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    @Autowired
    public UserConverter(ModelMapper modelMapper, UserRepository userRepository, RoleRepository roleRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public UserDTO toDTO(User userE) {
        UserDTO userDTO = modelMapper.map(userE, UserDTO.class);
        List<Integer> roleIdList = new ArrayList<>();
        for (Role roleE : userE.getRoles()){
            if(roleE != null)
                roleIdList.add(roleE.getId());
        }
        userDTO.setRoleIdList(roleIdList);
        return userDTO;
    }

    public User toEnity(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        List<Role> roles = new ArrayList<>();
        // Chuyển đổi chức vụ
        if(userDTO.getRoleIdList().isEmpty())
            roles.add(roleRepository.findByName("BUYER"));
        else
            for (int roleId : userDTO.getRoleIdList()) {
                Role roleE = roleRepository.findById(roleId);
                if(roleE != null)
                    roles.add(roleE);
            }
        user.setRoles(roles);
        return user;
    }
}
