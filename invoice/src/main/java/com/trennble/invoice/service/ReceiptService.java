package com.trennble.invoice.service;

import com.trennble.invoice.entity.Receipt;
import com.trennble.invoice.util.PageData;

import java.util.List;

public interface ReceiptService {

    Receipt add(Receipt receipt);

    Receipt update(Receipt receipt);

    Receipt fetch(int id);

    PageData<Receipt> list(int page, int limit,Receipt.Status status);

    void delete(Integer id);

    boolean fail(List<Integer> ids);

    boolean success(List<Integer> ids);

    boolean commit(List<Integer> ids);

    List<Receipt> curAll(Receipt.Status status);

    List<Receipt> all();

    boolean setReceiptInvoice(Integer receiptId, List<Integer> invoiceIds);
}
