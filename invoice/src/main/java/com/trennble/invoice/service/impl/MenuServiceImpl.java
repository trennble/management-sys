package com.trennble.invoice.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.trennble.auth.entity.Role;
import com.trennble.invoice.entity.Menu;
import com.trennble.invoice.repo.MenuRepo;
import com.trennble.invoice.service.MenuService;
import com.trennble.invoice.util.PageData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@Service
public class MenuServiceImpl implements MenuService {

    @Inject
    private MenuRepo menuRepo;

    @Inject
    private JdbcTemplate template;

    @Override
    public Menu save(Menu menu) {
        return menuRepo.save(menu);
    }

    @Override
    public void delete(Integer id) {
        menuRepo.delete(id);
    }

    @Override
    public Menu update(Menu menu) {
        return menuRepo.save(menu);
    }

    @Override
    public Menu fetch(Integer id) {
        return menuRepo.findOne(id);
    }

    @Override
    public PageData<Menu> list(int page, int limit) {
        Page<Menu> pageRes = menuRepo.findAll(new PageRequest(page, limit));
        return new PageData<>(pageRes.getContent(),pageRes.getTotalElements());
    }

    @Override
    public List<Map<String, Object>> menuRole() {

        List<Menu> menus = menuRepo.findByPidIsNull();

        List<Menu> allMenus = Lists.newArrayList();
        List<Map<String, Object>> res = Lists.newArrayList();

        allMenus.addAll(menus);
        menus.forEach(item -> {
            allMenus.addAll(item.getChildren());
        });

        allMenus.forEach(item -> {
            Map<String, Object> menu = Maps.newHashMap();
            menu.put("path", item.getPath());
            menu.put("icon", item.getIcon());
            menu.put("title", item.getTitle());
            menu.put("access", item.getRoles().stream().map(Role::getName).collect(toList()));
            menu.put("name", item.getName());
            res.add(menu);
        });

        return res;

    }

    @Override
    public List<Map<String, Object>> menuTree() {
        List<Menu> firstMenus = menuRepo.findByPidIsNull();
        List<Map<String,Object>> resList=Lists.newArrayList();
        firstMenus.forEach(menu->{
            List<Menu> subMenus = menu.getChildren();
            Map<String,Object> menuMap=Maps.newHashMap();
            List<Map<String,Object>> subList=Lists.newArrayList();
            subMenus.forEach(subMenu->{
                Map<String,Object> subMap=Maps.newHashMap();
                subMap.put("title",subMenu.getTitle());
                subMap.put("expand",false);
                subMap.put("remark",subMenu.getRemark());
                subMap.put("id",subMenu.getId());
                subList.add(subMap);
            });
            menuMap.put("children",subList);
            menuMap.put("title",menu.getTitle());
            menuMap.put("expand",false);
            menuMap.put("remark",menu.getRemark());
            menuMap.put("id",menu.getId());
            resList.add(menuMap);
        });
        return resList;
    }

    @Override
    public List<Role> findRoles(Integer menuId) {
        return menuRepo.findOne(menuId).getRoles();
    }

    @Override
    @Transactional
    public void setMenuRole(Integer menuId, List<Integer> roleIds) {

        // 删除所有的权限
        String deleteSql="delete from sys_menu_roles where sys_menu_id=?";
        template.update(deleteSql,menuId);

        // 设置新的权限
        String sql="insert INTO sys_menu_roles(roles_id, sys_menu_id) VALUES (?,?)";
        List<Object[]> args=Lists.newArrayList();
        for (Integer id:roleIds){
            Integer[] arg=new Integer[2];
            arg[0]=id;
            arg[1]=menuId;
            args.add(arg);
        }
        template.batchUpdate(sql,args);
    }
}
