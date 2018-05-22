package com.trennble.invoice.controller;

import com.trennble.invoice.entity.Receipt;
import com.trennble.invoice.service.ReceiptService;
import com.trennble.invoice.util.PageData;
import com.trennble.invoice.util.ServiceResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping("receipt")
public class ReceiptController {

    @Inject
    private ReceiptService receiptService;


    @PostMapping
    @ApiOperation("增加报销单")
    ServiceResult<Receipt> add(@RequestBody Receipt receipt) {
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

    @DeleteMapping
    @ApiOperation("删除报销单")
    ServiceResult delete(Integer id) {
        receiptService.delete(id);
        return ServiceResult.success(true);
    }

    @PutMapping("commit")
    @ApiOperation("删除报销单")
    ServiceResult commit(Integer id) {
        boolean state = receiptService.commit(id);
        return new ServiceResult(state);
    }

    @DeleteMapping("success")
    @ApiOperation("删除报销单")
    ServiceResult success(Integer id) {
        boolean state = receiptService.success(id);
        return new ServiceResult(state);
    }

    @DeleteMapping("fail")
    @ApiOperation("删除报销单")
    ServiceResult fail(Integer id) {
        boolean state = receiptService.fail(id);
        return new ServiceResult(state);
    }

}
