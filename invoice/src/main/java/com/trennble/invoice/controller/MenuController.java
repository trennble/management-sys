package com.trennble.invoice.controller;

import com.trennble.invoice.entity.Menu;
import com.trennble.invoice.service.MenuService;
import com.trennble.invoice.util.PageData;
import com.trennble.invoice.util.ServiceResult;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping("menu")
public class MenuController {

    @Inject
    private MenuService menuService;

    @PostMapping
    public ServiceResult save(Menu menu) {
        return ServiceResult.success(menuService.save(menu));
    }

    @DeleteMapping
    public ServiceResult delete(Integer id) {
        menuService.delete(id);
        return ServiceResult.success("true");
    }

    @PutMapping
    public ServiceResult update(Menu menu) {
        return ServiceResult.success(menuService.update(menu));
    }

    @GetMapping
    public ServiceResult fetch(Integer id) {
        return ServiceResult.success(menuService.fetch(id));
    }

    @GetMapping("list")
    public ServiceResult list(int page, int limit) {
        PageData pageRes = menuService.list(page, limit);
        return ServiceResult.success(pageRes);
    }

    @GetMapping("menuRole")
    public ServiceResult menuRole(){
        return ServiceResult.success(menuService.menuRole());
    }
}
