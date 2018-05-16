package com.trennble.invoice.vo;

import io.swagger.annotations.ApiModelProperty;

public class InvoiceVo {

    @ApiModelProperty("发票代码")
    private String invoiceCode;
    @ApiModelProperty("发票号码")
    private String invoiceNo;
    @ApiModelProperty("开票日期")
    private Long invoiceDate;
    @ApiModelProperty("校验码")
    private String checkCode;
    @ApiModelProperty("购买方名称")
    private String name;
    @ApiModelProperty("购买方纳税人识别号")
    private String TaxpayerCode;
    @ApiModelProperty("购买方地址")
    private String address;
    @ApiModelProperty("购买方开户行和账号")
    private String account;
    @ApiModelProperty("总额")
    private String amount;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("销售方名称")
    private String sellerName;
    @ApiModelProperty("销售方纳税人识别号")
    private String sellerCode;

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Long getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Long invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxpayerCode() {
        return TaxpayerCode;
    }

    public void setTaxpayerCode(String taxpayerCode) {
        TaxpayerCode = taxpayerCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerCode() {
        return sellerCode;
    }

    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }
}
