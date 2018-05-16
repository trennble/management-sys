package com.trennble.invoice.repo;

import com.trennble.invoice.entity.Menu;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MenuRepo extends PagingAndSortingRepository<Menu,Integer> {
}
