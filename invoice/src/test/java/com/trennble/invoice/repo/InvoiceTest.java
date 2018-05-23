package com.trennble.invoice.repo;

import com.trennble.invoice.InvoiceApplication;
import com.trennble.invoice.service.InvoiceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {InvoiceApplication.class})
public class InvoiceTest {

    @Inject
    private InvoiceService invoiceService;

    @Test
    public void valid(){
        invoiceService.validInvoice(1);
    }
}
