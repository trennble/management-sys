package com.trennble.invoice.repo;

import com.trennble.invoice.entity.Receipt;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReceiptRepo extends PagingAndSortingRepository<Receipt,Integer> {
}
