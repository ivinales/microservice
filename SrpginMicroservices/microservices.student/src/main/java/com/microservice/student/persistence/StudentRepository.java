package com.microservice.student.persistence;

import com.microservice.student.entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository  extends CrudRepository<Student, Long> {
    @Query("Select s from Student s where s.courseId = :courseId")
    List<Student> findAllByStudent(Long courseId);
    List<Student> findAllByCourseId(Long courseId);
}
