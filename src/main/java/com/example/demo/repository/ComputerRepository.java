package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Computer;

public interface ComputerRepository extends JpaRepository<Computer, Integer>{
	List<Computer> findByHangsanxuat(String hangsanxuat);
}
