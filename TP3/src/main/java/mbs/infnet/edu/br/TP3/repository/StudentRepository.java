package mbs.infnet.edu.br.TP3.repository;

import  mbs.infnet.edu.br.TP3.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
