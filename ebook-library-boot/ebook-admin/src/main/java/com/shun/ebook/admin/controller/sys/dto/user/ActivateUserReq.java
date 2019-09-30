package com.shun.ebook.admin.controller.sys.dto.user;

import lombok.Data;

/**
 * @author cxshun@gmail.com
 * 2019-08-08 15-02
 **/
@Data
public class ActivateUserReq {

    private Long id;
    /**
     * 激活类型，1-激活，0-禁用
     */
    private Integer operationType;

}
