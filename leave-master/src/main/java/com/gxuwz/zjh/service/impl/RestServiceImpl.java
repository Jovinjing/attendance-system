package com.gxuwz.zjh.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gxuwz.zjh.entity.Rest;
import com.gxuwz.zjh.entity.Thing;
import com.gxuwz.zjh.mapper.RestMapper;
import com.gxuwz.zjh.service.IRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestServiceImpl implements IRestService {

    @Autowired
    private RestMapper restMapper;

    @Override
    public IPage<Rest> selectPage(Page<Rest> page, Wrapper<Rest> wrapper) {
        return restMapper.selectRestPage(page, wrapper);
    }

    @Override
    public Rest findById(Rest rest) {
        return restMapper.findRestById(rest);
    }

    @Override
    public void addObject(Rest rest) {
        restMapper.addRest(rest);
    }

    @Override
    public void updateById(Rest rest) {
        restMapper.updateRestById(rest);
    }
}
