package com.crystal.tmis.service;

import com.crystal.tmis.entity.Batch;
import com.crystal.tmis.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourse();
    Course getCourseByID(Long id);
    void saveCourse(Course course);
}
