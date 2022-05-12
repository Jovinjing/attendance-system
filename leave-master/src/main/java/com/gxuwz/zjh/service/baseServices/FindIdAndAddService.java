package com.gxuwz.zjh.service.baseServices;

import com.gxuwz.zjh.entity.Thing;

public interface FindIdAndAddService<T> {
    // 根据 id 查询对应用户信息
    T findById(T t);
    // 添加用户信息
    void addObject(T t);
}
