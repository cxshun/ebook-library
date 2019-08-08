package com.shun.ebook.user.constant;

import lombok.Getter;

/**
 * @author cxshun@gmail.com
 * 2019-08-07 10-26
 **/
@Getter
public enum PrivilegePoint {

    /**
     * privilege type
     */
    PAGE(1, "page privilege"),
    POINT(2, "point privilege");

    private int val;
    private String desc;

    PrivilegePoint(int val, String desc) {
        this.val = val;
        this.desc = desc;
    }

}
