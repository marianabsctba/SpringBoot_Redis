package mbs.infnet.edu.br.TP3.service;


import mbs.infnet.edu.br.TP3.entity.Course;
import mbs.infnet.edu.br.TP3.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class CourseCacheService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private CourseRepository courseRepository;

    private static final String COURSE_CACHE_PREFIX = "COURSE_";

    public Course getCourseById(Long courseId) {
        String key = COURSE_CACHE_PREFIX + courseId;
        Course course = (Course) redisTemplate.opsForValue().get(key);
        if (course == null) {
            course = courseRepository.findById(courseId).orElse(null);
            if (course != null) {
                redisTemplate.opsForValue().set(key, course, 10, TimeUnit.MINUTES);
            }
        }
        return course;
    }

    public void evictCourseCache(Long courseId) {
        String key = COURSE_CACHE_PREFIX + courseId;
        redisTemplate.delete(key);
    }
}

