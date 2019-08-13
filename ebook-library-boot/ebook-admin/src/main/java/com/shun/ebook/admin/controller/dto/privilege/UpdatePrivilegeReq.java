package com.shun.ebook.admin.controller.dto.privilege;

import lombok.Data;

/**
 * shun
 * 2019-08-08
 **/
@Data
public class UpdatePrivilegeReq {

    private Long id;
    private String name;
    private String desc;
    private Integer type;

}
