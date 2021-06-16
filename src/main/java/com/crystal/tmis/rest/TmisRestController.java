package com.crystal.tmis.rest;

import com.crystal.tmis.dto.BatchDto;
import com.crystal.tmis.entity.Batch;
import com.crystal.tmis.entity.Course;
import com.crystal.tmis.service.BatchService;
import com.crystal.tmis.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class TmisRestController {

    private BatchService batchService;
    private CourseService courseService;

    @Autowired
    public TmisRestController(BatchService batchService, CourseService courseService) {
        this.batchService = batchService;
        this.courseService = courseService;
    }

    @GetMapping("allBatch")
    public List<Batch> allBatches(){
        return batchService.getAllBatch();
    }

    @PostMapping("addBatch")
    public Batch addBatch(@RequestBody Batch batch){
        batchService.saveBatch(batch);
        return batch;
    }

    @PostMapping("addCourse")
    public Course addCourse(@RequestBody Course course){
        courseService.saveCourse(course);
        return course;
    }

    @GetMapping("getCourse/{theId}")
    public Course findCourse(@PathVariable Long theId){
        return courseService.getCourseByID(theId);
    }

    @GetMapping("allCourse")
    public List<Course> allCourses(){
        return courseService.getAllCourse();
    }

    @GetMapping("batchByCourses/{id}")
    public List<Batch> getBatchByCourse(@PathVariable Long id){
        return batchService.getBatchesByCourse(id);
    }

}
