package com.trennble.invoice.service.impl;

import com.trennble.auth.entity.User;
import com.trennble.invoice.repo.UserRepo;
import com.trennble.invoice.service.UserService;
import com.trennble.invoice.util.PageData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

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
}
