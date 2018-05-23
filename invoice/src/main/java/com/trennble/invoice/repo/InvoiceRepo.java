package com.trennble.invoice.repo;

import com.trennble.invoice.entity.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface InvoiceRepo extends PagingAndSortingRepository<Invoice, Integer> {

    Page<Invoice> findByUserId(Integer userId, Pageable page);

    List<Invoice> findAllByUserId(Integer userId);

    @Query(value = "SELECT * FROM invoice i WHERE NOT exists(SELECT 0 FROM receipt_invoices ri WHERE ri.invoices_id = i.id AND ri.receipt_id<>?1) AND i.owner_id=?2",
            nativeQuery = true)
    List<Invoice> findValid(Integer receiptId,Integer userId);
}
