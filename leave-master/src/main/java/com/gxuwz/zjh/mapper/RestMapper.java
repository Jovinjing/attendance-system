package com.gxuwz.zjh.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gxuwz.zjh.entity.Rest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RestMapper {
    IPage<Rest> selectRestPage(Page<Rest> page, @Param(Constants.WRAPPER) Wrapper<Rest> wrapper);

    Rest findRestById(Rest rest);

    void addRest(Rest rest);

    void updateRestById(Rest rest);
}
