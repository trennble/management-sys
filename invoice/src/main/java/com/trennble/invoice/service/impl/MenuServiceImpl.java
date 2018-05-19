package com.trennble.invoice.service.impl;

import com.trennble.invoice.entity.Menu;
import com.trennble.invoice.repo.MenuRepo;
import com.trennble.invoice.service.MenuService;
import com.trennble.invoice.util.PageData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class MenuServiceImpl implements MenuService {

    @Inject
    private MenuRepo menuRepo;

    @Override
    public Menu save(Menu menu) {
        return menuRepo.save(menu);
    }

    @Override
    public void delete(Integer id) {
        menuRepo.delete(id);
    }

    @Override
    public Menu update(Menu menu) {
        return menuRepo.save(menu);
    }

    @Override
    public Menu fetch(Integer id) {
        return menuRepo.findOne(id);
    }

    @Override
    public PageData<Menu> list(int page, int limit) {
        Page<Menu> pageRes = menuRepo.findAll(new PageRequest(page, limit));
        return new PageData<>(pageRes.getContent(),pageRes.getTotalElements());
    }
}
