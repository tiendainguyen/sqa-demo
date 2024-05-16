package com.example.demo.service.Impl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.entity.Computer;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
import com.example.demo.repository.ComputerRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.ComputerService;
//import com.example.demo.service.OrderDetailService;
import com.example.demo.service.OrderService;

@SessionScope
@Service
public class OrderServiceImpl implements OrderService{
	Map<Integer, Order> maps = new HashMap<>();
	
	@Autowired
	private OrderRepository orderRepository;
	
//	@Autowired
//	private OrderDetailService orderDetailService;
	
	@Autowired
	private ComputerRepository computerRepository;
	
	@Autowired
	private ComputerService computerService;

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

	@Override
	public List<Order> getAllOrdersByUsername(String username) {
		// TODO Auto-generated method stub
		return orderRepository.getAllByUsername(username);
	}

	@Override
	public Order saveOrder(Order order) {
		// TODO Auto-generated method stub
		return orderRepository.save(order);
	}

	

//	@Override
//	public Order getOrderById(int orderId) {
//		// TODO Auto-generated method stub
//		return orderRepository.getById(orderId);
//	}

//	@Override
//	public Order placeOrder(String username, List<OrderDetail> orderDetails) {
//		// TODO Auto-generated method stub
//		if (!orderDetailService.checkInventory(orderDetails)) {
//			throw new InsufficientInventoryException("Not enough inventory for the order");
//		}
//		float totalAmount = orderDetailService.totalAmount(orderDetails);
//		
//		Order order = new Order();
//		order.setUsername(username);
//		order.setOrderDetails(orderDetails);
//		order.setNgaymua(LocalDate.now());
//		order.setTongtien(totalAmount);
//		
//		orderRepository.save(order);
//		
//		for (OrderDetail orderDetail: orderDetails) {
//			int computerId = orderDetail.getComputerId();
//			Computer computer = computerService.getComputerById(computerId);
//			computer.setSoluong(computer.getSoluong()-orderDetail.getSoluong());
//			computerRepository.save(computer);
//		}
//		
//		return order;
//	}
	
//	public void add(Order order) {
//		Order order2 = maps.get(order.get);
//	}
}
