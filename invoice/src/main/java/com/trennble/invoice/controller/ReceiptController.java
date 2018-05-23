package com.trennble.invoice.controller;

import com.trennble.invoice.entity.Receipt;
import com.trennble.invoice.service.ReceiptService;
import com.trennble.invoice.util.PageData;
import com.trennble.invoice.util.ServiceResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("receipt")
public class ReceiptController {

    @Inject
    private ReceiptService receiptService;


    @PostMapping
    @ApiOperation("增加报销单")
    ServiceResult<Receipt> add(@RequestBody Receipt receipt) {
        // receipt.set
        return ServiceResult.success(receiptService.add(receipt));
    }

    @PutMapping
    @ApiOperation("更新报销单")
    ServiceResult<Receipt> update(@RequestBody Receipt receipt) {
        return ServiceResult.success(receiptService.update(receipt));
    }

    @GetMapping
    @ApiOperation("获取报销单详情")
    ServiceResult<Receipt> list(int id) {
        return ServiceResult.success(receiptService.fetch(id));
    }

    @GetMapping("list")
    @ApiOperation("获取报销单列表")
    ServiceResult<PageData<Receipt>> list(int page, int limit, Receipt.Status status) {
        return ServiceResult.success(receiptService.list(page, limit, status));
    }

    @GetMapping("all")
    @ApiOperation("获取所有报销单列表")
    ServiceResult all(Receipt.Status status) {
        return ServiceResult.success(receiptService.all(status));
    }

    @DeleteMapping
    @ApiOperation("删除报销单")
    ServiceResult delete(Integer id) {
        receiptService.delete(id);
        return ServiceResult.success(true);
    }

    @PutMapping("commit")
    @ApiOperation("提交报销单")
    ServiceResult commit(@RequestBody List<Integer> ids) {
        boolean state = receiptService.commit(ids);
        return new ServiceResult(state);
    }

    @PutMapping("success")
    @ApiOperation("审核通过")
    ServiceResult success(@RequestBody List<Integer> ids) {
        boolean state = receiptService.success(ids);
        return new ServiceResult(state);
    }

    @PutMapping("fail")
    @ApiOperation("打回报销单")
    ServiceResult fail(@RequestBody List<Integer> ids) {
        boolean state = receiptService.fail(ids);
        return new ServiceResult(state);
    }

    @PutMapping("users")
    @ApiOperation("为当前报销单设置发票")
    public ServiceResult setRoleUser(Integer receiptId,@RequestBody List<Integer> invoiceIds){
        receiptService.setReceiptInvoice(receiptId,invoiceIds);
        return ServiceResult.success(true);
    }

}
