package mbs.infnet.edu.br.TP3.service;


import mbs.infnet.edu.br.TP3.entity.Student;
import mbs.infnet.edu.br.TP3.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}

