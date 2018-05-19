package com.trennble.auth.config;

import com.trennble.auth.entity.User;
import com.trennble.auth.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sang on 2017/1/10.
 */
public class CustomUserService implements UserDetailsService {

    @Autowired
    UserRepo userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        // user.getRoles().forEach(item->item.setUsers(null));
        System.out.println("username:"+user.getUsername()+";password:"+user.getPassword());
        // SysUserDetail sysUserDetail=new SysUserDetail();
        // sysUserDetail.setUser(user);
        return user;
    }
}
