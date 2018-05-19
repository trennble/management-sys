package com.trennble.invoice.service.impl;

import com.trennble.invoice.entity.Receipt;
import com.trennble.invoice.repo.ReceiptRepo;
import com.trennble.invoice.service.ReceiptService;
import com.trennble.invoice.util.PageData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    @Inject
    private ReceiptRepo receiptRepo;

    @Override
    public Receipt add(Receipt receipt) {
        return receiptRepo.save(receipt);
    }

    @Override
    public Receipt update(Receipt receipt) {
        return receiptRepo.save(receipt);
    }

    @Override
    public Receipt fetch(int id) {
        return receiptRepo.findOne(id);
    }

    @Override
    public PageData<Receipt> list(int page, int limit) {
        Page<Receipt> data = receiptRepo.findAll(new PageRequest(page, limit));
        return new PageData<>(data.getContent(),data.getTotalElements());
    }

    @Override
    public void delete(Integer id) {
        receiptRepo.delete(id);
    }
}
