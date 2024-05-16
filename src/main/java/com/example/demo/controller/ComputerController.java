package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Computer;
import com.example.demo.service.ComputerService;
import com.example.demo.service.UserService;

@Controller
public class ComputerController {
	@Autowired
	private ComputerService computerService;
	@Autowired
	private UserService userService;
	
	
public ComputerController(ComputerService computerService, UserService userService) {
		super();
		this.computerService = computerService;
		this.userService = userService;
	}

//	@GetMapping("/computers")
//	public String listComputers(@RequestParam String username, Model model) {
////		String username = (String) model.getAttribute("username");
//		model.addAttribute("username", username);
//		model.addAttribute("computers", computerService.getAllComputers());
//		return "computers";
////		return findPaginated(1, model);
//	}
	
	@GetMapping("/computers")
	public String listComputers(Model model) {
//		String username = (String) model.getAttribute("username");
		String username = userService.getUsername();
		model.addAttribute("username", username);
		model.addAttribute("computers", computerService.getAllComputers());
		return "computers";
//		return findPaginated(1, model);
	}
	
//	@GetMapping("/computers_user")
//	public String listComputersUser(@RequestParam String username, Model model) {
////		String username = (String) model.getAttribute("username");
//		model.addAttribute("username", username);
//		model.addAttribute("computers", computerService.getAllComputers());
//		return "/computers_user";
////		return findPaginated(1, model);
//	}
	
	@GetMapping("/computers_user")
	public String listComputersUser(Model model) {
//		String username = (String) model.getAttribute("username");
		String username = userService.getUsername();
		model.addAttribute("username", username);
		model.addAttribute("computers", computerService.getAllComputers());
		return "/computers_user";
//		return findPaginated(1, model);
	}
	
	@GetMapping("/computers/search")
	public String searchByHangSX(@RequestParam("keyword") String keyword,Model model) {
//		String username = (String) model.getAttribute("username");
		String username = userService.getUsername();
		model.addAttribute("username", username);
		List<Computer> computers = computerService.searchByHangSanXuat(keyword);
		model.addAttribute("computers", computers);
		return "computers";
//		return findPaginated(1, model);
	}
	
	@GetMapping("/computers_user/search")
	public String searchByHangSXUser(@RequestParam("keyword") String keyword,Model model) {
//		String username = (String) model.getAttribute("username");
		String username = userService.getUsername();
		model.addAttribute("username", username);
		List<Computer> computers = computerService.searchByHangSanXuat(keyword);
		model.addAttribute("computers", computers);
		return "computers_user";
//		return findPaginated(1, model);
	}
	
	@GetMapping("/computers/add")
	public String createComputerForm(Model model) {
		Computer computer = new Computer();
		model.addAttribute("computer", computer);
		return "create_conmputer";
	}
	
	@PostMapping("/computers")
	public String saveComputer(@ModelAttribute("computer") Computer computer) {
		computerService.saveComputer(computer);
		return "redirect:/computers";
	}
	
	@GetMapping("/computers/edit/{id}")
	public String editComputerForm(@PathVariable Integer id, Model model) {
		model.addAttribute("computer", computerService.getComputerById(id));
		return "edit_computer";
	}
	
	@PostMapping("/computers/{id}")
	public String updateComputer(@PathVariable Integer id, @ModelAttribute("computer") Computer computer, Model model) {
		//get computer from DB id
		Computer existingComputer = computerService.getComputerById(id);
		existingComputer.setID(id);
		existingComputer.setAnh(computer.getAnh());
		existingComputer.setCpu(computer.getCpu());
		existingComputer.setDongia(computer.getDongia());
		existingComputer.setHangsanxuat(computer.getHangsanxuat());
		existingComputer.setHedieuhanh(computer.getHedieuhanh());
		existingComputer.setManhinh(computer.getManhinh());
		existingComputer.setOcung(computer.getManhinh());
		existingComputer.setRam(computer.getRam());
		existingComputer.setSoluong(computer.getSoluong());
		existingComputer.setTen(computer.getTen());
		
		//save update computer
		computerService.updateComputer(existingComputer);
		return "redirect:/computers";
	}
	
	//hander method to handle delete computer request
	@GetMapping("/computers/{id}")
	public String deleteComputer(@PathVariable Integer id) {
		computerService.deleteComputerById(id);
		return "redirect:/computers";
	}
	
	@GetMapping("/computers/page/pageNo/{pageSize}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model ) {
		int pageSize = 10;
		Page<Computer> page = computerService.findPaginated(pageNo, pageSize);
		List<Computer> lisComputers = page.getContent();
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalpages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("listComputers", lisComputers);
		return "computers";
		
	}
}
