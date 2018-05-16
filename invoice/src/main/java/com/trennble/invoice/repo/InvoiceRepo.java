package com.trennble.invoice.repo;

import com.trennble.invoice.entity.Invoice;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InvoiceRepo extends PagingAndSortingRepository<Invoice,Integer> {
}
