package com.microservice.student.controller;

import com.microservice.student.entities.Student;
import com.microservice.student.persistence.StudentRepository;
import com.microservice.student.service.IStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private IStudentsService studentsService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(Student student) {
        studentsService.save(student);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllStudent(){
        return ResponseEntity.ok(studentsService.findAll());
    }


    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(studentsService.findById(id));
    }

    @GetMapping("/search-by-course/{CourseId}")
    public ResponseEntity<?> findByIdCourse(@PathVariable Long CourseId) {
        return ResponseEntity.ok(studentsService.findByCourseId(CourseId));
    }
}
