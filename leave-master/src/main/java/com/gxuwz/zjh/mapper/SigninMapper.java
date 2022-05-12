package com.gxuwz.zjh.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gxuwz.zjh.entity.Signin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SigninMapper {
    IPage<Signin> selectSigninPage(Page<Signin> page, @Param(Constants.WRAPPER) Wrapper<Signin> wrapper);

    Signin findSigninById(Signin signin);

    void addSignin(Signin signin);
}
