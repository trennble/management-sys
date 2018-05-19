package com.trennble.invoice.repo;

import com.trennble.auth.entity.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RoleRepo extends PagingAndSortingRepository<Role,Integer> {
}
