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
        Receipt one = receiptRepo.findOne(receipt.getId());
        one.setName(receipt.getName());
        one.setRemark(receipt.getName());
        return receiptRepo.save(one);
    }

    @Override
    public Receipt fetch(int id) {
        return receiptRepo.findOne(id);
    }

    @Override
    public PageData<Receipt> list(int page, int limit, Receipt.Status status) {
        Page<Receipt> data;
        PageRequest pageable = new PageRequest(page, limit);
        if (status != null) {
            data = receiptRepo.findByStatus(status, pageable);
        } else {

            data = receiptRepo.findAll(pageable);
        }
        return new PageData<>(data.getContent(), data.getTotalElements());
    }

    @Override
    public void delete(Integer id) {
        receiptRepo.delete(id);
    }

    @Override
    public boolean fail(Integer id) {
        Receipt one = receiptRepo.findOne(id);
        one.setStatus(Receipt.Status.fail);
        receiptRepo.save(one);
        return true;
    }

    @Override
    public boolean success(Integer id) {
        Receipt one = receiptRepo.findOne(id);
        one.setStatus(Receipt.Status.success);
        receiptRepo.save(one);
        return true;
    }

    @Override
    public boolean commit(Integer id) {
        Receipt one = receiptRepo.findOne(id);
        one.setStatus(Receipt.Status.commit);
        receiptRepo.save(one);
        return true;
    }
}
