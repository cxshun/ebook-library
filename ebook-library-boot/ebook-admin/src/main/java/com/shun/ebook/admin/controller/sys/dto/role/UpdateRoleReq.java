package com.shun.ebook.admin.controller.sys.dto.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenxs(chenxs @ xiaopeng.com)——车联网基础平台
 * 2019-09-30 11-15
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRoleReq {

    /**
     * 角色ID
     */
    private Long id;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色描述
     */
    private String desc;

}
