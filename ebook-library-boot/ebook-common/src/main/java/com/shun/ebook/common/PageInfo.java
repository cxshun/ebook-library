package com.shun.ebook.common;

import lombok.Getter;

/**
 * @author cxshun@gmail.com
 * 2019-08-08 14-54
 **/
@Getter
public class PageInfo {

    private long total;
    private int totalPage;
    private int page;
    private int pageSize;

    public PageInfo(long total, int page, int pageSize) {
        this.total = total;
        this.page = page;
        this.pageSize = pageSize;
        this.totalPage = (int)(total / pageSize + (total % pageSize == 0 ? 0 : 1));
    }

}
