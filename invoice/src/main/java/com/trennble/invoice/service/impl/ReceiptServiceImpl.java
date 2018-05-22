package com.trennble.invoice.service.impl;

import com.trennble.invoice.entity.Receipt;
import com.trennble.invoice.repo.ReceiptRepo;
import com.trennble.invoice.rpc.UserRpc;
import com.trennble.invoice.service.ReceiptService;
import com.trennble.invoice.util.PageData;
import com.trennble.invoice.util.ServiceUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    @Inject
    private ReceiptRepo receiptRepo;

    @Inject
    private UserRpc userRpc;

    @Override
    public Receipt add(Receipt receipt) {
        Integer userId = (Integer) ((HashMap) userRpc.user().get("principal")).get("id");
        String userName = (String) ((HashMap) userRpc.user().get("principal")).get("username");
        receipt.setUserId(userId);
        receipt.setUserName(userName);
        receipt.setStatus(Receipt.Status.created);
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
        Integer userId = (Integer) ((HashMap) userRpc.user().get("principal")).get("id");
        Page<Receipt> data;
        PageRequest pageable = new PageRequest(page, limit);
        if (status != null) {
            data = receiptRepo.findByStatusAndUserId(status, userId, pageable);
        } else {
            data = receiptRepo.findByUserId(userId, pageable);
        }
        return new PageData<>(data.getContent(), data.getTotalElements());
    }

    @Override
    public void delete(Integer id) {
        receiptRepo.delete(id);
    }

    @Override
    public boolean fail(List<Integer> ids) {
        Iterable<Receipt> list = receiptRepo.findAll(ids);
        list.forEach(item->{
            item.setStatus(Receipt.Status.fail);
        });
        receiptRepo.save(list);
        return true;
    }

    @Override
    public boolean success(List<Integer> ids) {
        Iterable<Receipt> list = receiptRepo.findAll(ids);
        list.forEach(item->{
            item.setStatus(Receipt.Status.success);
        });
        receiptRepo.save(list);
        return true;
    }

    @Override
    public boolean commit(List<Integer> ids) {
        Iterable<Receipt> list = receiptRepo.findAll(ids);
        list.forEach(item->{
            item.setStatus(Receipt.Status.commit);
        });
        receiptRepo.save(list);
        return true;
    }
}
