package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;

public interface OrderService {
	List<Order> getAllOrders();
	List<Order> getAllOrdersByUsername(String username);
	Order saveOrder(Order order);

}
