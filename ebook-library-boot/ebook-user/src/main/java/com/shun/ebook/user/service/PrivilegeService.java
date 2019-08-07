package com.shun.ebook.user.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shun.ebook.user.dao.PrivilegeDao;
import com.shun.ebook.user.entity.Privilege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenxs(chenxs @ xiaopeng.com)——车联网基础平台
 * 2019-08-07 11-03
 **/
@Service
public class PrivilegeService extends BaseService<Privilege, Long>{
    @Autowired
    private PrivilegeDao privilegeDao;

    @Override
    protected BaseMapper<Privilege> getMapper() {
        return privilegeDao;
    }
}
