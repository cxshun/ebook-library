package com.shun.ebook.admin.controller.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shun.ebook.admin.controller.sys.dto.common.BaseListResp;
import com.shun.ebook.admin.controller.sys.dto.role.AddRoleReq;
import com.shun.ebook.admin.controller.sys.dto.role.UpdateRoleReq;
import com.shun.ebook.common.PageInfo;
import com.shun.ebook.common.constant.GlobalConstant;
import com.shun.ebook.user.entity.Role;
import com.shun.ebook.user.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author chenxs(chenxs @ xiaopeng.com)——车联网基础平台
 * 2019-09-30 11-12
 **/
@RestController
@RequestMapping("/admin/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 添加新角色
     * @param addRoleReq    请求内容体
     */
    @SuppressWarnings("Duplicates")
    @PostMapping("")
    public void add(AddRoleReq addRoleReq) {
        Date date = new Date();

        Role role = new Role();
        BeanUtils.copyProperties(addRoleReq, role);
        role.setCreateTime(date);
        role.setUpdateTime(date);
        role.setIsDeleted(GlobalConstant.FALSE);

        roleService.insert(role);
    }

    /**
     * 更新角色信息
     * @param updateRoleReq     请求内容体
     */
    @PutMapping("")
    public void update(UpdateRoleReq updateRoleReq) {
        Role role = new Role();
        BeanUtils.copyProperties(updateRoleReq, role);
        role.setUpdateTime(new Date());

        roleService.update(role);
    }

    /**
     * 删除指定的角色
     * @param id    角色ID
     */
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) {
        roleService.delete(id);
    }

    /**
     * 获取角色列表
     * @return  角色列表
     */
    @GetMapping("")
    public BaseListResp<Role> list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                   @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) {
        Page<Role> pager = roleService.list(new QueryWrapper<>(), page, pageSize);
        return new BaseListResp<>(pager.getRecords(), new PageInfo(pager.getTotal(), page, pageSize));
    }

}
