package com.gxuwz.zjh.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gxuwz.zjh.entity.User;
import com.gxuwz.zjh.mapper.UserMapper;
import com.gxuwz.zjh.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 管理员表 服务实现类
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(User user) {
        return userMapper.findUserById(user);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findUserAll();
    }

    @Override
    public IPage<User> selectPage(Page<User> page, Wrapper<User> wrapper) {
        return userMapper.selectUserPage(page, wrapper);
    }

    @Override
    public void addObject(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void updateById(User user) {
        userMapper.updateUserById(user);
    }

    @Override
    public void deleteById(User user) {
        userMapper.deleteUserById(user);
    }
}
