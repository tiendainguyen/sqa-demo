package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.CartItem;
import com.example.demo.entity.Computer;
import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import com.example.demo.service.ComputerService;
//import com.example.demo.service.OrderDetailService;
import com.example.demo.service.OrderService;
import com.example.demo.service.ShoppingCartService;
import com.example.demo.service.UserService;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	
//	@Autowired
//	private OrderDetailService orderDetailService;
	
	@Autowired
	private ComputerService computerService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@GetMapping("viewOrders_admin")
	public String viewOrderAdmins(Model model) {
		String username = userService.getUsername();
		model.addAttribute("username", username);
		model.addAttribute("listOrder", orderService.getAllOrders());
		return "viewOrders_admin";
	}
	
	@GetMapping("viewOrders_user")
	public String viewOrderUsers(Model model) {
		String username = userService.getUsername();
		model.addAttribute("username", username);
		model.addAttribute("listOrder", orderService.getAllOrdersByUsername(username));
		return "viewOrders_user";
	}
}
