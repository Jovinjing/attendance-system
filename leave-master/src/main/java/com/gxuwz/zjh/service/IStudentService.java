package com.gxuwz.zjh.service;

import com.gxuwz.zjh.entity.Student;
import com.gxuwz.zjh.service.baseServices.AbstractService;
import com.gxuwz.zjh.service.baseServices.SelectPageService;

import java.util.List;

/**
 * 学生表 服务类
 */
public interface IStudentService  extends AbstractService<Student>, SelectPageService<Student> {

    List<Student> findStudentByClassId(Student student);

}
