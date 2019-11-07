package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.repository.entity.Student;

public interface RepositoryStudent extends CrudRepository<Student, Long>{

}
