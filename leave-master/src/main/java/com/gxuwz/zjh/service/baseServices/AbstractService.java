package com.gxuwz.zjh.service.baseServices;


import java.util.List;

public interface AbstractService<T> extends FindIdAndAddService<T>{

    // 查询全部用户信息
    List<T> findAll();

    // 修改用户信息
    void updateById(T t);

    // 删除用户信息
    void deleteById(T t);
}
