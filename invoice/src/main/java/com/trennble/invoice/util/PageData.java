package com.trennble.invoice.util;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenxh on 2018/1/4.
 */
public class PageData<T> implements Serializable {
    private List<T> content;
    private long totalElements = 0;

    public PageData() {
        this(new ArrayList<>(), 0L);
    }


    public PageData(List<T> content, long totalElements) {
        this.content = content;
        this.totalElements = totalElements;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }
}