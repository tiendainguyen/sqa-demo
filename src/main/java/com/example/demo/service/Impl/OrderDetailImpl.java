//package com.example.demo.service.Impl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.example.demo.entity.Computer;
//import com.example.demo.entity.OrderDetail;
//import com.example.demo.repository.ComputerRepository;
//import com.example.demo.repository.OrderDetailRepository;
//import com.example.demo.service.ComputerService;
//import com.example.demo.service.OrderDetailService;
//
//public class OrderDetailImpl implements OrderDetailService {
//	@Autowired
//	private OrderDetailRepository orderDetailRepository;
//	
//	@Autowired
//	private ComputerRepository computerRepository;
//	
//	@Autowired
//	private ComputerService computerService;
//
//	@Override
//	public List<OrderDetail> getAllOrderDetailByOrder(int orderId) {
//		// TODO Auto-generated method stub
//		return orderDetailRepository.getAllByOrder(orderId);
//	}
//
//	@Override
//	public float totalAmount(List<OrderDetail> orderDetails) {
//		// TODO Auto-generated method stub
//		float amount = 0;
//		for (OrderDetail orderDetail: orderDetails) {
//			amount += (orderDetail.getSoluong()*orderDetail.getGia());
//		}
//		return amount;
//	}
//
//	@Override
//	public boolean checkInventory(List<OrderDetail> orderDetails) {
//		// TODO Auto-generated method stub
//		for (OrderDetail orderDetail: orderDetails) {
//			int computerId = orderDetail.getComputerId();
////			Computer computer = computerRepository.getById(computerId);
//			Computer computer = computerService.getComputerById(computerId);
//			if (orderDetail.getSoluong()>computer.getSoluong()) {
//				return false;
//			}
//		}
//		return true;
//	}
//
//}
