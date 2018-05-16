package com.trennble.invoice.entity;


import com.trennble.auth.entity.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "receipt")
public class Receipt {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String remark;

    @ManyToOne
    private User owner;

    @OneToMany
    private List<Invoice> invoices;

    private LocalDateTime updateDate;

    private LocalDateTime createDate;

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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
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
}
