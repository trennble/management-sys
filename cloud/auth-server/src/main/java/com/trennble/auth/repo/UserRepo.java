package com.trennble.auth.repo;

import com.trennble.auth.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by sang on 2017/1/10.
 */
public interface UserRepo extends PagingAndSortingRepository<User, Long> {
    User findByUsername(String username);
}
