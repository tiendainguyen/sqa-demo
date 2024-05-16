package com.example.demo.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Computer;
import com.example.demo.entity.User;
import com.example.demo.service.ComputerService;
import com.example.demo.service.UserService;

@Controller
public class UserController {
//	private ComputerService computerService;
	private UserService userService;

//	public UserController(ComputerService computerService) {
//		super();
//		this.computerService = computerService;
//	}
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/registration")
	public String registrationUserForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "registration";
	}
	
	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/registration?success";
	}
	
	@GetMapping("/login")
	public String loginForm(Model model) {
		User user = new User();
		String username = user.getUsername();
		model.addAttribute("username", username);
		model.addAttribute("user", user);
		return "login";
	}
	
//	@PostMapping("/login")
//	public String login(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
//		if (userService.checkUserByUsername(user.getUsername()) == false) {
//			return "redirect:/login?usernameWrong";
//		}
//		if (userService.checkUsernamePassword(user.getUsername(), user.getPassword())) {
//			if (userService.checkAdmin(user.getUsername(), user.getPassword())) {
//				String username = user.getUsername();
//				userService.setUsername(username);
//				redirectAttributes.addAttribute("username", username);
//				return "redirect:/computers";
//			}
//			
//			String username = user.getUsername();
//			userService.setUsername(username);
//			redirectAttributes.addAttribute("username", username);
//			return "redirect:/computers_user";
//		}
//		return "redirect:/login?passwordWrong";
//	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("user") User user) {
		if (userService.checkUserByUsername(user.getUsername()) == false) {
			return "redirect:/login?usernameWrong";
		}
		if (userService.checkUsernamePassword(user.getUsername(), user.getPassword())) {
			if (userService.checkAdmin(user.getUsername(), user.getPassword())) {
				String username = user.getUsername();
				userService.setUsername(username);
				return "redirect:/computers";
			}
			
			String username = user.getUsername();
			userService.setUsername(username);
			return "redirect:/computers_user";
		}
		return "redirect:/login?passwordWrong";
	}
}
