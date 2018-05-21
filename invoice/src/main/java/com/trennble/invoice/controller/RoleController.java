package com.trennble.invoice.controller;

import com.trennble.auth.entity.Role;
import com.trennble.invoice.service.RoleService;
import com.trennble.invoice.util.PageData;
import com.trennble.invoice.util.ServiceResult;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("role")
public class RoleController {

    @Inject
    private RoleService roleService;

    @PostMapping
    public ServiceResult save(Role role) {
        return ServiceResult.success(roleService.save(role));
    }

    @DeleteMapping
    public ServiceResult delete(Integer id) {
        if (roleService.delete(id))
            return ServiceResult.success("delete success");
        else
            return ServiceResult.fail("该角色存在用户，不能删除");
    }

    @PutMapping
    public ServiceResult update(Role role) {
        return ServiceResult.success(roleService.update(role));
    }

    @GetMapping
    public ServiceResult fetch(Integer id) {
        return ServiceResult.success(roleService.fetch(id));
    }

    @GetMapping("list")
    public ServiceResult list(int page, int limit) {
        PageData pageRes = roleService.list(page, limit);
        return ServiceResult.success(pageRes);
    }

    @GetMapping("all")
    public ServiceResult all() {
        List<Role> roles = roleService.all();
        return ServiceResult.success(roles);
    }

}
