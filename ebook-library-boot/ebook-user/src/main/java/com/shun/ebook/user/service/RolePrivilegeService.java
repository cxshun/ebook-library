package com.shun.ebook.user.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shun.ebook.user.dao.RolePrivilegeDao;
import com.shun.ebook.user.entity.RolePrivilege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cxshun@gmail.com
 * 2019-08-07 11-37
 **/
@Service
public class RolePrivilegeService extends BaseService<RolePrivilege, Long> {
    @Autowired
    private RolePrivilegeDao rolePrivilegeDao;

    @Override
    protected BaseMapper<RolePrivilege> getMapper() {
        return rolePrivilegeDao;
    }
}
