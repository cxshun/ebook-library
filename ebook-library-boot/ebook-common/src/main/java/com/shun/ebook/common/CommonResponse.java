package com.shun.ebook.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenxs(chenxs @ xiaopeng.com)——车联网基础平台
 * 2019-08-13 15-24
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse {

    private Object data;
    private Integer code;
    private String msg;

}
