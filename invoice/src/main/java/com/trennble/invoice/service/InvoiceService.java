package com.trennble.invoice.service;

import com.trennble.invoice.util.PageData;
import com.trennble.invoice.entity.Invoice;

import java.util.List;

public interface InvoiceService {

    Invoice add(Invoice invoice);

    Invoice update(Invoice invoice);

    Invoice fetch(int id);

    PageData<Invoice> list(int page, int limit);

    void delete(Integer id);

    List<Invoice> validInvoice(Integer receiptId);
}
