package com.shun.ebook.admin.controller.sys.dto.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cxshun@gmail.com
 * 2019-09-30 11-13
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddRoleReq {

    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色描述
     */
    private String desc;

}
