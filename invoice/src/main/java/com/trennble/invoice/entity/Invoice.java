package com.trennble.invoice.entity;

import com.trennble.auth.entity.User;
import com.trennble.invoice.vo.InvoiceVo;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "invoice")
public class Invoice {

    public enum Status{
        valid,invalid
    }

    @Id
    @GeneratedValue
    @ApiModelProperty
    private Integer id;
    @ApiModelProperty(hidden = true)
    @Enumerated(EnumType.STRING)
    private Status status;
    // @ManyToOne
    // @ApiModelProperty(hidden = true)
    // private User owner;
    // @ManyToOne
    // @ApiModelProperty(hidden = true)
    // private Receipt recp;
    @ApiModelProperty(hidden = true)
    private LocalDateTime updateDate;
    @ApiModelProperty(hidden = true)
    private LocalDateTime createDate;
    @Column(name="owner_id")
    private Integer userId;
    @Column(name = "recp_id")
    private Integer recpId;

    @ApiModelProperty(value = "发票代码",required = true)
    private String invoiceCode;
    @ApiModelProperty(value = "发票号码",required = true)
    private String invoiceNo;
    @ApiModelProperty(value = "开票日期",required = true)
    private LocalDate invoiceDate;
    @ApiModelProperty(value = "校验码",required = true)
    private String checkCode;
    @ApiModelProperty(value = "购买方名称",required = true)
    private String name;
    @ApiModelProperty(value = "购买方纳税人识别号",required = true)
    private String TaxpayerCode;
    @ApiModelProperty(value = "购买方地址")
    private String address;
    @ApiModelProperty(value = "购买方开户行和账号")
    private String account;
    @ApiModelProperty(value = "总额",required = true)
    private Double amount;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "销售方名称",required = true)
    private String sellerName;
    @ApiModelProperty(value = "销售方纳税人识别号",required = true)
    private String sellerCode;

    public Invoice() {
    }

    public Invoice(InvoiceVo invoiceVo) {
        Field[] declaredFields = InvoiceVo.class.getDeclaredFields();
        for (Field field : declaredFields) {
            String name = field.getName();
            field.getType();
        }
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

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

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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

    public Integer getRecpId() {
        return recpId;
    }

    public void setRecpId(Integer recpId) {
        this.recpId = recpId;
    }
}
