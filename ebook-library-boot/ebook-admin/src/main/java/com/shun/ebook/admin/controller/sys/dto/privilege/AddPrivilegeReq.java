package com.shun.ebook.admin.controller.sys.dto.privilege;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * shun
 * 2019-08-08
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPrivilegeReq {

    private String name;
    private String desc;
    private Integer type;

}
