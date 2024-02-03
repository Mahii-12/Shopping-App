package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Quiz;
import com.example.demo.model.User;

@Repository
public interface QuizRepo extends JpaRepository<Quiz,Integer>{
	 List<Quiz> findByUser(User user);
}
