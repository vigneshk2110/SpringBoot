package com.vicky;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	
	@GetMapping("/home")
	public String homePage(Model model) {
		model.addAttribute("abcd", "Welcome to Thymeleaf");
		return "index";
	}

}
