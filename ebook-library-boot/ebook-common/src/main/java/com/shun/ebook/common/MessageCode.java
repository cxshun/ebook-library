package com.shun.ebook.common;

import lombok.Data;
import lombok.Getter;

/**
 * @author cxshun@gmail.com
 * 2019-08-13 15-25
 **/
@Getter
public enum MessageCode {

    SUCCESS(200, "success");

    private int code;
    private String desc;
    MessageCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
