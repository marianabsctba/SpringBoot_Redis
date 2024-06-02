package mbs.infnet.edu.br.TP3.service;

import mbs.infnet.edu.br.TP3.entity.Course;
import mbs.infnet.edu.br.TP3.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course getCourseById(Long courseId) {
        return courseRepository.findById(courseId).orElse(null);
    }

    public void deleteCourseById(Long courseId) {
        courseRepository.deleteById(courseId);
    }
}
