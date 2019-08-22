package com.shun.ebook.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cxshun@gmail.com
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
