package com.trennble.invoice.service.impl;

import com.google.common.collect.Lists;
import com.trennble.auth.entity.User;
import com.trennble.invoice.repo.UserRepo;
import com.trennble.invoice.service.UserService;
import com.trennble.invoice.util.PageData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Inject
    private UserRepo userRepo;

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public void delete(Integer id) {
        userRepo.delete(id);
    }

    @Override
    public User update(User user) {
        return userRepo.save(user);
    }

    @Override
    public User fetch(Integer id) {
        return userRepo.findOne(id);
    }

    @Override
    public PageData<User> list(int page, int limit) {
        Page<User> pageRes = userRepo.findAll(new PageRequest(page, limit));
        return new PageData<>(pageRes.getContent(),pageRes.getTotalElements());
    }

    @Override
    public List<User> findByIds(List<Integer> ids) {
        return  Lists.newArrayList(userRepo.findAll(ids));
    }

    @Override
    public List<User> all() {
        return Lists.newArrayList(userRepo.findAll());
    }
}
