package com.shun.ebook.user.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shun.ebook.user.dao.RoleDao;
import com.shun.ebook.user.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenxs(chenxs @ xiaopeng.com)——车联网基础平台
 * 2019-08-07 11-36
 **/
@Service
public class RoleService extends BaseService<Role, Long> {
    @Autowired
    private RoleDao roleDao;

    @Override
    protected BaseMapper<Role> getMapper() {
        return roleDao;
    }
}
