package com.example.springhibernate.repositories;

import com.example.springhibernate.entities.Cours;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursRepository extends CrudRepository<Cours, Long> {
}
