package com.shun.ebook.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shun.ebook.admin.controller.dto.common.BaseListResp;
import com.shun.ebook.admin.controller.dto.privilege.AddPrivilegeReq;
import com.shun.ebook.admin.controller.dto.privilege.UpdatePrivilegeReq;
import com.shun.ebook.common.PageInfo;
import com.shun.ebook.common.constant.GlobalConstant;
import com.shun.ebook.user.entity.Privilege;
import com.shun.ebook.user.service.PrivilegeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * shun
 * 2019-08-08
 **/
@RestController
@RequestMapping("/admin/privileges")
public class PrivilegeController {
    @Autowired
    private PrivilegeService privilegeService;

    /**
     * 新增权限信息
     * @param addPrivilegeReq   权限信息
     */
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void add(@RequestBody AddPrivilegeReq addPrivilegeReq) {
        Date date = new Date();

        Privilege privilege = new Privilege();
        BeanUtils.copyProperties(addPrivilegeReq, privilege);
        privilege.setCreateTime(date);
        privilege.setUpdateTime(date);
        privilege.setIsDeleted(GlobalConstant.FALSE);
        privilegeService.insert(privilege);
    }

    /**
     * 更新权限信息
     * @param updatePrivilegeReq    权限实体
     */
    @PutMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void update(@RequestBody UpdatePrivilegeReq updatePrivilegeReq) {
        Privilege privilege = new Privilege();
        BeanUtils.copyProperties(updatePrivilegeReq, privilege);
        privilege.setUpdateTime(new Date());

        privilegeService.update(privilege);
    }

    /**
     * 获取权限信息列表
     * @param page          请求页码
     * @param pageSize      每页显示条数
     * @return  权限信息列表
     */
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseListResp<Privilege> list(@RequestParam("page") Integer page,
                                        @RequestParam("pageSize") Integer pageSize) {
        Page<Privilege> pager = privilegeService.list(new QueryWrapper<>(), page, pageSize);

        return new BaseListResp<>(pager.getRecords(), new PageInfo(pager.getTotal(), page, pageSize));
    }

    /**
     * 删除指定的权限项
     * @param id    权限ID
     */
    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void delete(@PathVariable("id") Long id) {
        privilegeService.delete(id);
    }

}
