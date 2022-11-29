package com.example.springhibernate.repositories;

import com.example.springhibernate.entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepository extends CrudRepository<Student, Long> {
    @Query("select s from Student s")
    List<Student> getAll();

    @Query("select s.id from Student s WHERE s.name = :name")
    Integer findIdByName(String name);

    @Query("select s from Student s WHERE s.name = :name")
    Student findByName(String name);


}
