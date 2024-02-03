package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Quiz;

@Repository
public interface QuestionRepo extends  JpaRepository<Question,Long>{

}
