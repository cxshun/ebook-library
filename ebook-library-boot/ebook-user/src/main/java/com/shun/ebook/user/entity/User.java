package com.shun.ebook.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * user info
 * @author cxshun@gmail.com
 * 2019-08-06 17-08
 **/
@Data
@TableName("`user`")
public class User {
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 邮件
     */
    private String email;
    /**
     * 是否启用，1-启用，0-停用
     */
    private Integer active;
    /**
     * 是否删除，1-已删除，0-有效
     */
    private Integer deleted;
    /**
     * createTime for record
     */
    private Date createTime;
    /**
     * updateTime for record
     */
    @TableLogic
    private Date updateTime;

}
