package com.example.springhibernate.dtos;


import com.example.springhibernate.entities.Cours;
import com.example.springhibernate.entities.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConverterEntitiesToDto {

    public static StudentDto toDto(Student student){
        StudentDto studentDto = new StudentDto(
                student.getId(),
                student.getName(),
                student.getCourses().stream().map(Cours::getCourse).collect(Collectors.toList())
        );
        return studentDto;
    }

    public static List<StudentDto> toDtos(List<Student> students){
        List<StudentDto> list = new ArrayList<>();
        for(Student s: students){
            StudentDto studentDto = new StudentDto(
                    s.getId(),
                    s.getName(),
                    s.getCourses().stream().map(Cours::getCourse).collect(Collectors.toList())
            );
            list.add(studentDto);
        }
        return list;
    }
}
