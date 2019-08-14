package com.project2.mvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
	
	@RequestMapping("/")
	public String home() {
		return "rawr";
	}
}
