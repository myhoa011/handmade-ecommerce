package com.tmdt.handmade.util.converter.account;

import com.tmdt.handmade.dto.account.RoleDTO;
import com.tmdt.handmade.entity.account.Role;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter {
    private final ModelMapper modelMapper;

    @Autowired
    public RoleConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public RoleDTO toDTO(Role roleE) {
        return modelMapper.map(roleE, RoleDTO.class);
    }

    public Role toEntity(RoleDTO roleD) {
        return modelMapper.map(roleD, Role.class);
    }
}
