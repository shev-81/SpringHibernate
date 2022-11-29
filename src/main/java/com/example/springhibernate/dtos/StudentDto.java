package com.example.springhibernate.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

   private Long id;

   private String name;

   private List<String> coursesName = new ArrayList<>();

   public StudentDto(Long id, String name) {
      this.id = id;
      this.name = name;
   }
}
