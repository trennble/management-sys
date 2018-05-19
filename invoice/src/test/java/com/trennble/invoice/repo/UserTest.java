package com.trennble.invoice.repo;


import com.google.common.collect.Lists;
import com.trennble.auth.entity.User;
import com.trennble.invoice.InvoiceApplication;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {InvoiceApplication.class})
public class UserTest {

    @Inject
    private UserRepo user;

    @Test
    public void init() throws IOException {


        ArrayList<User> sysUsers = Lists.newArrayList(user.findAll());
        ObjectMapper objectMapper=new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(sysUsers));


    }


}
