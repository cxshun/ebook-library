package com.shun.ebook.user.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shun.ebook.user.dao.UserDao;
import com.shun.ebook.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cxshun@gmail.com
 * 2019-08-07 11-38
 **/
@Service
public class UserService extends BaseService<User, Long> {
    @Autowired
    private UserDao userDao;

    @Override
    protected BaseMapper<User> getMapper() {
        return userDao;
    }
}
