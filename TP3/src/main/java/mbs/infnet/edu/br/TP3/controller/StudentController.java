package mbs.infnet.edu.br.TP3.controller;


import mbs.infnet.edu.br.TP3.entity.Student;
import mbs.infnet.edu.br.TP3.exception.ResourceNotFoundException;
import mbs.infnet.edu.br.TP3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @PutMapping("/{studentId}")
    public Student updateStudent(@PathVariable Long studentId, @RequestBody Student studentDetails) {
        Student student = studentService.getStudentById(studentId);
        if (student == null) {
            throw new ResourceNotFoundException("Student not found with id " + studentId);
        }
        student.setStudentName(studentDetails.getStudentName());
        student.setEnrolledCourses(studentDetails.getEnrolledCourses());
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudentById(studentId);
    }
}