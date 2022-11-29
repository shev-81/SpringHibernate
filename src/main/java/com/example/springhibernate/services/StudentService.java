package com.example.springhibernate.services;

import com.example.springhibernate.dtos.ConverterEntitiesToDto;
import com.example.springhibernate.dtos.StudentDto;
import com.example.springhibernate.entities.Cours;
import com.example.springhibernate.entities.Student;
import com.example.springhibernate.repositories.CoursRepository;
import com.example.springhibernate.repositories.StudentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentsRepository studentsRepository;
    private final CoursRepository coursRepository;

    public List<StudentDto> getAllStudents(){
        List<Student> students = studentsRepository.getAll();
        return ConverterEntitiesToDto.toDtos(students);
    }

    public StudentDto getStudentByid(Integer id){
        Student student = studentsRepository.findById(id.longValue()).orElse(new Student("No name"));
        return ConverterEntitiesToDto.toDto(student);
    }

    public Integer getIdStudentByName(String name){
        return studentsRepository.findIdByName(name);
    }

    public void deleteStudentByName(Integer id){
        Student student = studentsRepository.findById(id.longValue()).get();
        studentsRepository.delete(student);
    }

    @Transactional
    public void createNewStudent(String name){
        Student student = new Student(name);
        studentsRepository.save(student);
        Cours cours1 = new Cours("Mechanics", student);
        Cours cours2 = new Cours("Materials Science", student);
        coursRepository.save(cours1);
        coursRepository.save(cours2);
    }


}

