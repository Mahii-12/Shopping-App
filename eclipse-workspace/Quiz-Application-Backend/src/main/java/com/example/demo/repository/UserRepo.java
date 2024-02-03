package com.example.demo.repository;

import com.example.demo.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{
	

}
