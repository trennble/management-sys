package com.trennble.invoice.service.impl;

import com.google.common.collect.Lists;
import com.trennble.auth.entity.User;
import com.trennble.invoice.repo.UserRepo;
import com.trennble.invoice.rpc.UserRpc;
import com.trennble.invoice.service.UserService;
import com.trennble.invoice.util.PageData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Inject
    private UserRepo userRepo;

    @Inject
    private UserRpc userRpc;

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
        Integer userId = (Integer) ((HashMap) userRpc.user().get("principal")).get("id");
        User one = userRepo.findOne(userId);
        one.setUsername(user.getUsername());
        one.setEmail(user.getEmail());
        one.setPhone(user.getPhone());
        return userRepo.save(one);
    }

    @Override
    public User fetch(Integer id) {
        if (id==null||id==0){
            Integer userId = (Integer) ((HashMap) userRpc.user().get("principal")).get("id");
            return userRepo.findOne(userId);
        }
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

    @Override
    public void resetPasswd(String old, String last) throws Exception {

        Integer userId = (Integer) ((HashMap) userRpc.user().get("principal")).get("id");

        User user = userRepo.findOne(userId);

        if (!user.getPassword().equals(old)){
            throw new Exception("密码错误");
        }

        user.setPassword(last);
        userRepo.save(user);
    }
}
