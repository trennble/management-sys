package com.trennble.invoice.service.impl;

import com.trennble.auth.entity.Role;
import com.trennble.invoice.repo.RoleRepo;
import com.trennble.invoice.service.RoleService;
import com.trennble.invoice.util.PageData;
import org.assertj.core.util.Lists;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Inject
    private RoleRepo roleRepo;

    @Override
    public Role save(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void delete(Integer id) {
        roleRepo.delete(id);
    }

    @Override
    public Role update(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public Role fetch(Integer id) {
        return roleRepo.findOne(id);
    }

    @Override
    public PageData<Role> list(int page, int limit) {
        Page<Role> pageRes = roleRepo.findAll(new PageRequest(page, limit));
        return new PageData<>(pageRes.getContent(),pageRes.getTotalElements());
    }

    @Override
    public List<Role> all() {
        return Lists.newArrayList(roleRepo.findAll());
    }
}
