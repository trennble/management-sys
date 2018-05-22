package com.trennble.invoice.controller;

import com.trennble.auth.entity.User;
import com.trennble.invoice.service.UserService;
import com.trennble.invoice.util.PageData;
import com.trennble.invoice.util.ServiceResult;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Inject
    private UserService userService;

    @PostMapping
    public ServiceResult save(@RequestBody User user) {
        return ServiceResult.success(userService.save(user));
    }

    @DeleteMapping
    public ServiceResult delete(Integer id) {
        userService.delete(id);
        return ServiceResult.success("true");
    }

    @PutMapping
    public ServiceResult update(@RequestBody User user) {
        return ServiceResult.success(userService.update(user));
    }

    @GetMapping
    public ServiceResult fetch(Integer id) {
        return ServiceResult.success(userService.fetch(id));
    }

    @GetMapping("list")
    public ServiceResult list(int page, int limit) {
        PageData pageRes = userService.list(page, limit);
        return ServiceResult.success(pageRes);
    }
    @GetMapping("all")
    public ServiceResult all() {
        List<User> allUser = userService.all();
        return ServiceResult.success(allUser);
    }

}
