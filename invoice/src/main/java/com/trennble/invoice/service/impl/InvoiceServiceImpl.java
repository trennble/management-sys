package com.trennble.invoice.service.impl;

import com.trennble.invoice.entity.Invoice;
import com.trennble.invoice.repo.InvoiceRepo;
import com.trennble.invoice.service.InvoiceService;
import com.trennble.invoice.util.PageData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Inject
    private InvoiceRepo invoiceRepo;

    @Override
    public Invoice add(Invoice invoice) {
        return invoiceRepo.save(invoice);
    }

    @Override
    public Invoice update(Invoice invoice) {
        return invoiceRepo.save(invoice);
    }

    @Override
    public Invoice fetch(int id) {
        return invoiceRepo.findOne(id);
    }

    @Override
    public PageData<Invoice> list(int page, int limit) {
        Page<Invoice> data = invoiceRepo.findAll(new PageRequest(page, limit));
        return new PageData<>(data.getContent(),data.getTotalElements());
    }

    @Override
    public void delete(Integer id) {
        invoiceRepo.delete(id);
    }
}
