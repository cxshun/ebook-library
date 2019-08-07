package com.shun.ebook.user.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shun.ebook.user.dao.UserRoleDao;
import com.shun.ebook.user.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenxs(chenxs @ xiaopeng.com)——车联网基础平台
 * 2019-08-07 11-38
 **/
@Service
public class UserRoleService extends BaseService<UserRole, Long> {
    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    protected BaseMapper<UserRole> getMapper() {
        return userRoleDao;
    }
}
