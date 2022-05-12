package com.gxuwz.zjh.service.baseServices;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

public interface SelectPageService<T> {
    //自定义sql 分页
    IPage<T> selectPage(Page<T> page, @Param(Constants.WRAPPER) Wrapper<T> wrapper);
}
