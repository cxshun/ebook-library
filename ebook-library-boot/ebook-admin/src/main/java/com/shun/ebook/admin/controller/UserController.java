package com.shun.ebook.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shun.ebook.admin.controller.dto.common.BaseListResp;
import com.shun.ebook.admin.controller.dto.user.ActivateUserReq;
import com.shun.ebook.admin.controller.dto.user.AddUserReq;
import com.shun.ebook.admin.controller.dto.user.UpdateUserReq;
import com.shun.ebook.common.PageInfo;
import com.shun.ebook.common.constant.GlobalConstant;
import com.shun.ebook.user.entity.User;
import com.shun.ebook.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author cxshun@gmail.com
 * 2019-08-07
 **/
@RestController
@RequestMapping("/admin/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 添加新用户
     * @param addUserReq    新用户信息
     */
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void add(@RequestBody AddUserReq addUserReq) {
        Date date = new Date();

        User user = new User();
        user.setIsActive(GlobalConstant.TRUE);
        user.setCreateTime(date);
        user.setUpdateTime(date);
        user.setEmail(addUserReq.getEmail());
        user.setName(addUserReq.getName());
        user.setIsDeleted(GlobalConstant.FALSE);
        user.setPassword(addUserReq.getPassword());

        userService.insert(user);
    }

    /**
     * 更新用户信息
     * @param updateUserReq 更新信息
     */
    @PutMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void update(@RequestBody UpdateUserReq updateUserReq) {
        Date date = new Date();

        User user = new User();
        user.setName(updateUserReq.getName());
        user.setUpdateTime(date);
        user.setEmail(updateUserReq.getEmail());
        user.setPassword(updateUserReq.getPassword());

        userService.update(user);
    }

    /**
     * 删除指定的用户信息
     * @param id    用户ID
     */
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }

    /**
     * 获取用户详情
     * @param id    用户ID
     * @return  用户信息
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User get(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    /**
     * 激活/禁用用户
     * @param activateUserReq   请求信息
     */
    @PostMapping(value = "/activate",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void activate(@RequestBody ActivateUserReq activateUserReq) {
        User user = new User();
        user.setUpdateTime(new Date());
        user.setId(activateUserReq.getId());
        user.setIsActive(activateUserReq.getOperationType());

        userService.update(user);
    }

    /**
     * 获取用户列表
     * @param page      请求页码
     * @param pageSize  每页显示条数
     * @return  用户列表
     */
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseListResp<User> list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                   @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) {
        Page<User> pager = userService.list(new QueryWrapper<>(), page, pageSize);
        return new BaseListResp<>(pager.getRecords(), new PageInfo(pager.getTotal(), page, pageSize));
    }

}
