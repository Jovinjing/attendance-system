package com.gxuwz.zjh.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gxuwz.zjh.entity.Worker;
import com.gxuwz.zjh.mapper.WorkerMapper;
import com.gxuwz.zjh.service.IWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WorkerServiceImpl implements IWorkerService {

    @Autowired
    private WorkerMapper workerMapper;

    @Override
    public Worker findById(Worker worker) {
        return workerMapper.findStudentById(worker);
    }

    @Override
    public  List<Worker> findStudentByClassId(Worker worker) {
        return workerMapper.findStudentByClassId(worker);
    }

    @Override
    public List<Worker> findAll() {
        return workerMapper.findStudentAll();
    }

    @Override
    public IPage<Worker> selectPage(Page<Worker> page, Wrapper<Worker> wrapper) {
        return workerMapper.selectStudentPage(page, wrapper);
    }

    @Override
    public void addObject(Worker worker) {
        workerMapper.addStudent(worker);
    }

    @Override
    public void updateById(Worker worker) {
        workerMapper.updateStudentById(worker);
    }

    @Override
    public void deleteById(Worker worker) {
        workerMapper.deleteStudentById(worker);
    }
}
