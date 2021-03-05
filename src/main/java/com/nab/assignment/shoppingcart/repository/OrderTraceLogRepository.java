package com.nab.assignment.shoppingcart.repository;

import com.nab.assignment.shoppingcart.model.OrderTraceLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderTraceLogRepository extends JpaRepository<OrderTraceLog, UUID> {
}
