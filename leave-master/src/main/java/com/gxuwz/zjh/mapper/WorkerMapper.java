package com.gxuwz.zjh.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gxuwz.zjh.entity.Worker;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 工人表 Mapper 接口
 */
@Mapper
@Repository
public interface WorkerMapper {

    // 根据 id 查询对应用户信息
    Worker findWorkerById(Worker worker);

    List<Worker> findWorkerByClassId(Worker worker);

    // 查询全部用户信息
    List<Worker> findWorkerAll();

    //自定义sql 分页
    IPage<Worker> selectWorkerPage(Page<Worker> page, @Param(Constants.WRAPPER) Wrapper<Worker> wrapper);

    // 添加用户信息
    void addWorker(Worker worker);

    // 修改用户信息
    void updateWorkerById(Worker worker);

    // 删除用户信息
    void deleteWorkerById(Worker worker);

}
