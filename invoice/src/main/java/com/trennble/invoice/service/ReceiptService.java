package com.trennble.invoice.service;

import com.trennble.invoice.entity.Receipt;

import java.util.List;

public interface ReceiptService {

    Receipt add(Receipt receipt);

    Receipt update(Receipt receipt);

    List<Receipt> list(int page, int limit);

    void delete(Integer id);
}
