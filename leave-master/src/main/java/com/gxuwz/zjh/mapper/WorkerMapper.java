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
    Worker findStudentById(Worker worker);

    List<Worker> findStudentByClassId(Worker worker);

    // 查询全部用户信息
    List<Worker> findStudentAll();

    //自定义sql 分页
    IPage<Worker> selectStudentPage(Page<Worker> page, @Param(Constants.WRAPPER) Wrapper<Worker> wrapper);

    // 添加用户信息
    void addStudent(Worker worker);

    // 修改用户信息
    void updateStudentById(Worker worker);

    // 删除用户信息
    void deleteStudentById(Worker worker);

}
