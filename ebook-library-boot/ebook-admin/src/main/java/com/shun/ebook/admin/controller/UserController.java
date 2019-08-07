package com.shun.ebook.admin.controller;

import com.shun.ebook.admin.controller.dto.user.AddUserReq;
import com.shun.ebook.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * shun
 * 2019-08-07
 **/
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 添加新用户
     * @param addUserReq    新用户信息
     */
    public void add(@RequestBody AddUserReq addUserReq) {

    }

}
