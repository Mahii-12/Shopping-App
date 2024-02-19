package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;
import com.example.demo.entity.Wishlist;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist,Long>{

	public List<Wishlist> findByUser(User user);

}
