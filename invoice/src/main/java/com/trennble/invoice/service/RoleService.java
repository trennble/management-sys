package com.trennble.invoice.service;

import com.trennble.auth.entity.Role;
import com.trennble.invoice.util.PageData;

import java.util.List;

public interface RoleService {

    Role save(Role role);

    void delete(Integer id);

    Role update(Role role);

    Role fetch(Integer id);

    PageData list(int page, int limit);

    List<Role> all();

}
