package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Orders;
import com.example.demo.model.Users;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long>{


    boolean existsByUserAndCoupon(Users user, String couponCode);

    List<Orders> findByUserUserId(Long userId);

    List<Orders> findByUserUserIdAndOrderId(Long userId, Long orderId);

}
