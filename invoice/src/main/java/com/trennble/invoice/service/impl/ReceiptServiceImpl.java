package com.trennble.invoice.service.impl;

import com.google.common.collect.Lists;
import com.trennble.invoice.entity.Receipt;
import com.trennble.invoice.repo.ReceiptRepo;
import com.trennble.invoice.rpc.UserRpc;
import com.trennble.invoice.service.ReceiptService;
import com.trennble.invoice.util.PageData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    @Inject
    private ReceiptRepo receiptRepo;

    @Inject
    private JdbcTemplate template;

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
        list.forEach(item -> {
            item.setStatus(Receipt.Status.fail);
        });
        receiptRepo.save(list);
        return true;
    }

    @Override
    public boolean success(List<Integer> ids) {
        Iterable<Receipt> list = receiptRepo.findAll(ids);
        list.forEach(item -> {
            item.setStatus(Receipt.Status.success);
        });
        receiptRepo.save(list);
        return true;
    }

    @Override
    public boolean commit(List<Integer> ids) {
        Iterable<Receipt> list = receiptRepo.findAll(ids);
        list.forEach(item -> {
            item.setStatus(Receipt.Status.commit);
        });
        receiptRepo.save(list);
        return true;
    }

    @Override
    public List<Receipt> all(Receipt.Status status) {
        Integer userId = (Integer) ((HashMap) userRpc.user().get("principal")).get("id");
        if (status != null) {
            return receiptRepo.findByStatusAndUserId(status, userId);
        } else {
            return receiptRepo.findByUserId(userId);
        }
    }

    @Override
    public boolean setReceiptInvoice(Integer receiptId, List<Integer> invoiceIds) {

        // 删除所有的用户
        String deleteSql = "DELETE FROM receipt_invoices WHERE receipt_id=?";
        template.update(deleteSql, receiptId);

        // 设置新的用户
        String sql = "INSERT INTO receipt_invoices(invoices_id, receipt_id) VALUES (?,?)";
        List<Object[]> args = Lists.newArrayList();
        for (Integer id : invoiceIds) {
            Integer[] arg = new Integer[2];
            arg[0] = id;
            arg[1] = receiptId;
            args.add(arg);
        }
        template.batchUpdate(sql, args);
        return false;
    }
}
