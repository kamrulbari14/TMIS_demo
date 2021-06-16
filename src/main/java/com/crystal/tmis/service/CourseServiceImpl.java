package com.crystal.tmis.service;

import com.crystal.tmis.entity.Course;
import com.crystal.tmis.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseByID(Long id) {

        Optional<Course> result = courseRepository.findById(id);

        if (result.isPresent()){
            return result.get();
        }

        else {
            throw new RuntimeException("Not Found "+id);
        }
    }

    @Override
    public void saveCourse(Course course) {
        courseRepository.save(course);
    }
}
