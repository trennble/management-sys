package com.trennble.invoice.service;

import com.trennble.auth.entity.User;
import com.trennble.invoice.util.PageData;

import java.util.List;

public interface UserService {

    User save(User user);

    void delete(Integer id);

    User update(User user);

    User fetch(Integer id);

    PageData list(int page, int limit);

    List<User> findByIds(List<Integer> ids);

}
