package com.trennble.invoice.service;

import com.trennble.invoice.entity.Menu;

import java.util.List;

public interface MenuService {

    Menu save(Menu menu);

    void delete(Integer id);

    Menu update(Menu menu);

    Menu fetch(Integer id);

    List<Menu> list();
}
