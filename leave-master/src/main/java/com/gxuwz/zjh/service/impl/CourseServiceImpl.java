package com.gxuwz.zjh.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gxuwz.zjh.entity.Course;
import com.gxuwz.zjh.mapper.CourseMapper;
import com.gxuwz.zjh.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 表 服务实现类
 */
@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public Course findById(Course course) {
        return courseMapper.findCourseById(course);
    }

    @Override
    public List<Course> findAll() {
        return courseMapper.findCourseAll();
    }

    @Override
    public IPage<Course> selectPage(Page<Course> page, Wrapper<Course> wrapper) {
        return courseMapper.selectCoursePage(page, wrapper);
    }

    @Override
    public void addObject(Course course) {
        courseMapper.addCourse(course);
    }

    @Override
    public void updateById(Course course) {
        courseMapper.updateCourseById(course);
    }

    @Override
    public void deleteById(Course course) {
        courseMapper.deleteCourseById(course);
    }
}
