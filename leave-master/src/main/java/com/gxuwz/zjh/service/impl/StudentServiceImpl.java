package com.gxuwz.zjh.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gxuwz.zjh.entity.Student;
import com.gxuwz.zjh.mapper.StudentMapper;
import com.gxuwz.zjh.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学生表 服务实现类
 */
@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student findById(Student student) {
        return studentMapper.findStudentById(student);
    }

    @Override
    public  List<Student> findStudentByClassId(Student student) {
        return studentMapper.findStudentByClassId(student);
    }

    @Override
    public List<Student> findAll() {
        return studentMapper.findStudentAll();
    }

    @Override
    public IPage<Student> selectPage(Page<Student> page, Wrapper<Student> wrapper) {
        return studentMapper.selectStudentPage(page, wrapper);
    }

    @Override
    public void addObject(Student student) {
        studentMapper.addStudent(student);
    }

    @Override
    public void updateById(Student student) {
        studentMapper.updateStudentById(student);
    }

    @Override
    public void deleteById(Student student) {
        studentMapper.deleteStudentById(student);
    }
}
