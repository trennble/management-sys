package com.trennble.invoice.repo;

import com.trennble.invoice.entity.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InvoiceRepo extends PagingAndSortingRepository<Invoice,Integer> {

    Page<Invoice> findByUserId(Integer userId, Pageable page);
}
