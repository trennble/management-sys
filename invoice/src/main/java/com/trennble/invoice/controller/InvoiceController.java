package com.trennble.invoice.controller;

import com.trennble.invoice.entity.Invoice;
import com.trennble.invoice.service.InvoiceService;
import com.trennble.invoice.util.PageData;
import com.trennble.invoice.util.ServiceResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping("invoice")
public class InvoiceController {

    @Inject
    private InvoiceService invoiceService;


    @PostMapping
    @ApiOperation("增加发票")
    ServiceResult<Invoice> add(@RequestBody Invoice invoice){
        return ServiceResult.success(invoiceService.add(invoice));
    }

    @PutMapping
    @ApiOperation("更新发票")
    ServiceResult<Invoice> update(@RequestBody Invoice invoice){
        return ServiceResult.success(invoiceService.update(invoice));
    }

    @GetMapping
    @ApiOperation("获取发票详情")
    ServiceResult<Invoice> list(int id){
        return ServiceResult.success(invoiceService.fetch(id));
    }

    @GetMapping("list")
    @ApiOperation("获取发票列表")
    ServiceResult<PageData<Invoice>> list(int page, int limit){
        return ServiceResult.success(invoiceService.list(page,limit));
    }

    /**
     * 被添加到其他报销单中的为invalid，没被添加的或者被添加到当前报销单的为valid
     * @return
     */
    @GetMapping("valid")
    @ApiOperation("获取所有发票发票，但是加以区分")
    ServiceResult validInvoice(Integer receiptId){
        return ServiceResult.success(invoiceService.validInvoice(receiptId));
    }

    @DeleteMapping
    @ApiOperation("删除发票")
    ServiceResult<String> delete(Integer id){
        invoiceService.delete(id);
        return ServiceResult.success("success");
    }
}
