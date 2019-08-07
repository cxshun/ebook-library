package com.shun.ebook.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author cxshun@gmail.com
 * 2019-08-06 17-26
 **/
@Data
@TableName("privilege")
public class Privilege {

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 权限名称
     */
    private String name;
    /**
     * 描述
     */
    private String desc;
    /**
     * 类型, {@link com.shun.ebook.user.constant.PrivilegePoint}
     */
    private Integer type;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 是否删除，1-已删除，0-未删除
     */
    @TableLogic
    private Integer deleted;

}
