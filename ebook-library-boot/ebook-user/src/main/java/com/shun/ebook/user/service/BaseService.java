package com.shun.ebook.user.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.io.Serializable;
import java.util.List;

/**
 * @author chenxs(chenxs @ xiaopeng.com)——车联网基础平台
 * 2019-08-07 11-03
 **/
public abstract class BaseService<T, IdType extends Serializable> {

    /**
     * 获取指定entity的mapper
     * @return  mapper
     */
    protected abstract BaseMapper<T> getMapper();

    /**
     * 新增记录
     * @param t 实体内容
     * @return  true-新增成功，false-新增失败
     */
    public boolean insert(T t) {
        return getMapper().insert(t) > 0;
    }

    /**
     * 更新指定的记录
     * @param t 更新实体
     * @return  true-更新成功，false-更新失败
     */
    public boolean update(T t) {
        return getMapper().updateById(t) > 0;
    }

    /**
     * 删除指定的记录
     * @param id    主键ID
     * @return  true-删除成功，false-删除失败
     */
    public boolean delete(IdType id) {
        return getMapper().deleteById(id) > 0;
    }

    /**
     * 根据条件，获取实体列表
     * @param wrapper   条件实体
     * @return  实体列表
     */
    public List<T> list(Wrapper<T> wrapper) {
        return getMapper().selectList(wrapper);
    }

    /**
     * 根据ID获取数据
     * @param id    主键ID
     * @return  实体数据
     */
    public T getById(IdType id) {
        return getMapper().selectById(id);
    }

}
