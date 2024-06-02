package mbs.infnet.edu.br.TP3.controller;

import mbs.infnet.edu.br.TP3.entity.Course;
import mbs.infnet.edu.br.TP3.service.CourseService;
import mbs.infnet.edu.br.TP3.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @GetMapping("/{courseId}")
    public Course getCourseById(@PathVariable Long courseId) {
        Course course = courseService.getCourseById(courseId);
        if (course == null) {
            throw new ResourceNotFoundException("Course not found with id " + courseId);
        }
        return course;
    }

    @PutMapping("/{courseId}")
    public Course updateCourse(@PathVariable Long courseId, @RequestBody Course courseDetails) {
        Course course = courseService.getCourseById(courseId);
        if (course == null) {
            throw new ResourceNotFoundException("Course not found with id " + courseId);
        }
        course.setCourseName(courseDetails.getCourseName());
        course.setStudents(courseDetails.getStudents());
        return courseService.saveCourse(course);
    }

    @DeleteMapping("/{courseId}")
    public void deleteCourse(@PathVariable Long courseId) {
        courseService.deleteCourseById(courseId);
    }
}