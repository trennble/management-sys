package com.trennble.invoice.repo;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trennble.invoice.InvoiceApplication;
import com.trennble.invoice.entity.Receipt;
import com.trennble.invoice.service.ReceiptService;
import com.trennble.invoice.util.PageData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {InvoiceApplication.class})
public class ReceiptTest {

    @Inject
    private ReceiptService receiptService;

    @Test
    public void list() throws JsonProcessingException {
        PageData<Receipt> list = receiptService.list(0, 10, Receipt.Status.commit);
        System.out.println((new ObjectMapper()).writeValueAsString(list));
    }
}
