package com.trennble.invoice.repo;

import com.trennble.invoice.entity.Receipt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ReceiptRepo extends PagingAndSortingRepository<Receipt, Integer> {

    Page<Receipt> findByStatusAndUserId(Receipt.Status status, Integer userId, Pageable page);

    List<Receipt> findByStatusAndUserId(Receipt.Status status, Integer userId);

    List<Receipt> findByStatus(Receipt.Status status);

    Page<Receipt> findByUserId(Integer userId, Pageable page);

    List<Receipt> findByUserId(Integer userId);
}
