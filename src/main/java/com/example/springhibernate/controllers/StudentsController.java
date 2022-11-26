package com.example.springhibernate.controllers;

import com.example.springhibernate.dtos.StudentDto;
import com.example.springhibernate.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/student/{name}")
    public StudentDto getStudent(@PathVariable String name){
        return studentService.getStudentByName(name);
    }

    @DeleteMapping("/{name}")
    public void deleteStudent(@PathVariable String name){
        studentService.deleteStudentByName(name);
    }

    @PutMapping("/{name}")
    public void createNewStudent(@PathVariable String name){
        studentService.createNewStudent(name);
    }
}
