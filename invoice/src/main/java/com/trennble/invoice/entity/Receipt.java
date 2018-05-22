package com.trennble.invoice.entity;


import com.trennble.auth.entity.User;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "receipt")
public class Receipt {


    public enum Status{
        created,commit,success,fail
    }

    @Id
    @GeneratedValue
    private Integer id;

    @ApiModelProperty(hidden = true)
    @Enumerated(EnumType.STRING)
    private Status status;

    private String name;

    private String remark;

    @Column(name="owner_id")
    private Integer userId;

    // @ManyToOne
    // private User owner;

    @OneToMany
    private List<Invoice> invoices;

    private LocalDateTime updateDate;

    private LocalDateTime createDate;

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

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
