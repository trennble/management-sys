package com.trennble.invoice.service.impl;

import com.trennble.auth.entity.Role;
import com.trennble.auth.entity.User;
import com.trennble.invoice.repo.RoleRepo;
import com.trennble.invoice.service.RoleService;
import com.trennble.invoice.service.UserService;
import com.trennble.invoice.util.PageData;
import org.assertj.core.util.Lists;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Inject
    private RoleRepo roleRepo;

    @Inject
    private UserService userService;

    @Inject
    private JdbcTemplate template;

    @Override
    public Role save(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public boolean delete(Integer id) {
        if (findUsers(id).size()>0)
            return false;
        roleRepo.delete(id);
        return true;
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

    @Override
    public List<User> findUsers(Integer roleId) {
        String sql="select sys_user_id from sys_user_roles where roles_id=?";
        List<Integer> userIds = template.queryForList(sql, Integer.class, roleId);
        return userService.findByIds(userIds);
    }

    @Override
    public void setRoleUser(Integer roleId, List<Integer> userIds) {

        // 删除所有的用户
        String deleteSql="delete from sys_user_roles where roles_id=?";
        template.update(deleteSql,roleId);

        // 设置新的用户
        String sql="insert INTO sys_user_roles(sys_user_id, roles_id) VALUES (?,?)";
        List<Object[]> args= com.google.common.collect.Lists.newArrayList();
        for (Integer id:userIds){
            Integer[] arg=new Integer[2];
            arg[0]=id;
            arg[1]=roleId;
            args.add(arg);
        }
       template.batchUpdate(sql,args);
    }
}
