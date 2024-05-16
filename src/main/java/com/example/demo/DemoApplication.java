package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Computer;
import com.example.demo.entity.User;
import com.example.demo.repository.ComputerRepository;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private ComputerRepository computerRepository;
	private UserRepository userRepository;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Computer computer = new Computer("test", "test", "test", "test", "test", "test", "test", "test", "test");
//		computerRepository.save(computer);
		
//		Computer computer = new Computer("test", "test", "test", "test", "test", "test", "test", "test", "test");
//		computerRepository.save(computer);
		
//		
//		User user = new User("1", "2", "3", "4", "5", "6","7", 0);
//		userRepository.save(user);
	}

}
