package com.trennble.invoice.service;

import com.trennble.auth.entity.Role;
import com.trennble.invoice.entity.Menu;
import com.trennble.invoice.util.PageData;

import java.util.List;
import java.util.Map;

public interface MenuService {

    Menu save(Menu menu);

    void delete(Integer id);

    Menu update(Menu menu);

    Menu fetch(Integer id);

    PageData list(int page, int limit);

    List<Map<String, Object>> menuRole();

    List<Map<String,Object>> menuTree();

    List<Role> findRoles(Integer menuId);

    void setMenuRole(Integer menuId,List<Integer> roleIds);
}
