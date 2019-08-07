package com.shun.ebook.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author cxshun@gmail.com
 * 2019-08-06 17-33
 **/
@Data
@TableName("role_privilege")
public class RolePrivilege {

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 权限ID
     */
    private Long privilegeId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 是否删除，1-已删除，0-有效
     */
    private Integer deleted;

}
