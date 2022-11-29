package com.example.springhibernate.controllers;

import com.example.springhibernate.dtos.StudentDto;
import com.example.springhibernate.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentsController {

    private final StudentService studentService;

    @GetMapping
    public List<StudentDto> allStudents(){
        List<StudentDto> listCategory = studentService.getAllStudents();
        return listCategory;
    }

    @GetMapping("/getId/{name}")
    public Integer getStudentId(@PathVariable String name){
        return studentService.getIdStudentByName(name);
    }

    @GetMapping("/student/{id}")
    public StudentDto getStudent(@PathVariable Integer id){
        return studentService.getStudentByid(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id){
        studentService.deleteStudentByName(id);
    }

    @PostMapping()
    public void createNewStudent(@RequestBody StudentDto student){
        studentService.createNewStudent(student.getName());
    }
}
