package com.trennble.invoice.service.impl;

import com.google.common.collect.Lists;
import com.trennble.invoice.entity.Invoice;
import com.trennble.invoice.repo.InvoiceRepo;
import com.trennble.invoice.rpc.UserRpc;
import com.trennble.invoice.service.InvoiceService;
import com.trennble.invoice.util.PageData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Inject
    private InvoiceRepo invoiceRepo;

    @Inject
    private UserRpc userRpc;

    @Override
    public Invoice add(Invoice invoice) {
        Integer userId = (Integer) ((HashMap) userRpc.user().get("principal")).get("id");
        invoice.setUserId(userId);
        return invoiceRepo.save(invoice);
    }

    @Override
    public Invoice update(Invoice invoice) {
        Invoice one = invoiceRepo.findOne(invoice.getId());
        invoice.setCreateDate(one.getCreateDate());
        return invoiceRepo.save(invoice);
    }

    @Override
    public Invoice fetch(int id) {
        return invoiceRepo.findOne(id);
    }

    @Override
    public PageData<Invoice> list(int page, int limit) {
        Integer userId = (Integer) ((HashMap) userRpc.user().get("principal")).get("id");
        Page<Invoice> data = invoiceRepo.findByUserId(userId, new PageRequest(page, limit));
        return new PageData<>(data.getContent(), data.getTotalElements());
    }

    @Override
    public List<Invoice> validInvoice(Integer receiptId) {
        Integer userId = (Integer) ((HashMap) userRpc.user().get("principal")).get("id");

        // 找出没被添加的或者被添加到当前报销单的发票
        List<Invoice> valid = invoiceRepo.findValid(receiptId, userId).stream()
                .peek(item -> item.setStatus(Invoice.Status.valid)).collect(toList());
        List<Integer> validIds = valid.stream().map(Invoice::getId).collect(toList());

        //获取所有数据，然后理由有效数据把没效数据给标记
        List<Invoice> inValid = Lists.newArrayList(invoiceRepo.findAllByUserId(userId)).stream()
                .filter(item -> !validIds.contains(item.getId()))
                .peek(item -> item.setStatus(Invoice.Status.invalid)).collect(toList());

        valid.addAll(inValid);
        return valid;
    }

    @Override
    public void delete(Integer id) {
        invoiceRepo.delete(id);
    }
}
