package com.trennble.invoice.controller;

import com.trennble.invoice.entity.Menu;
import com.trennble.invoice.service.MenuService;
import com.trennble.invoice.util.PageData;
import com.trennble.invoice.util.ServiceResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

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
    @ApiOperation("获取菜单路由")
    public ServiceResult menuRole(){
        return ServiceResult.success(menuService.menuRole());
    }

    @GetMapping("menuTree")
    @ApiOperation("获取菜单树")
    public ServiceResult menuTree(){
        return ServiceResult.success(menuService.menuTree());
    }

    @GetMapping("roles")
    @ApiOperation("获取当前菜单角色")
    public ServiceResult findRoles(Integer menuId){
        return ServiceResult.success(menuService.findRoles(menuId));
    }

    @PutMapping("roles")
    @ApiOperation("为当前菜单设置角色")
    public ServiceResult setMenuRoles(Integer menuId, List<Integer> roleIds){
        menuService.setMenuRole(menuId,roleIds);
        return ServiceResult.success(true);
    }



}
