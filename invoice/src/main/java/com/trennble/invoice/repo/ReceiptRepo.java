package com.trennble.invoice.repo;

import com.trennble.invoice.entity.Receipt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReceiptRepo extends PagingAndSortingRepository<Receipt, Integer> {

    Page<Receipt> findByStatusAndUserId(Receipt.Status status, Integer userId, Pageable page);

    Page<Receipt> findByUserId(Integer userId, Pageable page);
}
