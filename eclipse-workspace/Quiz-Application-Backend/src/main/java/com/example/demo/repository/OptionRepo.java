package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Option;
import com.example.demo.model.Question;

@Repository
public interface OptionRepo extends JpaRepository<Option,Long>{
	 List<Option> findByQuestion(Question question);
}
