package com.example.demo.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageUploadController {
	@RequestMapping(value = "getimage/{anh}", method = RequestMethod.GET )
//	@GetMapping("/getimage/{photo}")
//	public String image() {
//		return "computers";
////		return findPaginated(1, model);
//	}
	@ResponseBody
	public ResponseEntity<ByteArrayResource> getImage(@PathVariable("anh") String anh ){
		if (!anh.equals("") || anh!=null) {
			try {
				Path filename = Paths.get("uploads", anh);
				byte[] buffer = Files.readAllBytes(filename);
				ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);
				return ResponseEntity.ok().contentLength(buffer.length).contentType(MediaType.parseMediaType("image/png")).body(byteArrayResource);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return ResponseEntity.badRequest().build();
	}
	
//	@GetMapping("/")
//	public String image() {
//		return "computers";
//	}
//	
//	@PostMapping("/imageUpload")
//	public String imageUpload(@RequestParam MultipartFile anh) {
//		System.out.println(anh.getOriginalFilename());
//		return "redirect:/";
//	}
}
