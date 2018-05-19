package com.trennble.auth;


import com.trennble.auth.entity.User;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class UserTest {

    public static void main(String[] args) throws IOException {
        User user=new User();
        user.setUsername("username");
        user.setPassword("password");
        ObjectMapper objectMapper=new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(user));
    }
}
