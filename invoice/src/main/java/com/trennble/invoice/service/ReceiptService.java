package com.trennble.invoice.service;

import com.trennble.invoice.entity.Receipt;
import com.trennble.invoice.util.PageData;

public interface ReceiptService {

    Receipt add(Receipt receipt);

    Receipt update(Receipt receipt);

    Receipt fetch(int id);

    PageData<Receipt> list(int page, int limit,Receipt.Status status);

    void delete(Integer id);

    boolean fail(Integer id);

    boolean success(Integer id);

    boolean commit(Integer id);

}
