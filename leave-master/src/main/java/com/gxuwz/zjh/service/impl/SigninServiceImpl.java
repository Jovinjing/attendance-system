package com.gxuwz.zjh.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gxuwz.zjh.entity.Signin;
import com.gxuwz.zjh.entity.Thing;
import com.gxuwz.zjh.mapper.SigninMapper;
import com.gxuwz.zjh.service.ISigninService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SigninServiceImpl implements ISigninService {

    @Autowired
    private SigninMapper signinMapper;

    @Override
    public IPage<Signin> selectPage(Page<Signin> page, Wrapper<Signin> wrapper) {
        return signinMapper.selectSigninPage(page, wrapper);
    }

    @Override
    public Signin findById(Signin signin) {
        return signinMapper.findSigninById(signin);
    }

    @Override
    public void addObject(Signin signin) {
        signinMapper.addSignin(signin);
    }
}
