package com.example.demo.repository;



import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

	public User findByUsername(String username);

	public Optional<User> findOptionalByUsername(String username);

	public Optional<User> findByEmail(String email);	

}
