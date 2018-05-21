package com.trennble.invoice.repo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.trennble.auth.entity.User;
import com.trennble.invoice.InvoiceApplication;
import com.trennble.invoice.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {InvoiceApplication.class})
public class RoleTest {

    @Inject
    private RoleService roleService;

    @Test
    public void setRoleUser(){
        Integer roleId=2;
        List<Integer> userIds= Lists.newArrayList(3,4,5,6);
        roleService.setRoleUser(roleId,userIds);
    }

    @Test
    public void findUsers() throws JsonProcessingException {
        List<User> users = roleService.findUsers(1);

        System.out.println((new ObjectMapper()).writeValueAsString(users));
    }


}
