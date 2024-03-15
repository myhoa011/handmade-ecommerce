package com.tmdt.handmade.service;

import com.tmdt.handmade.entity.account.Role;

public interface RoleService {
    Role findByName(String userName);
}
