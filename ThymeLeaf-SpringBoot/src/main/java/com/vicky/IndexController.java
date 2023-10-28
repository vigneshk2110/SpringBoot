package com.vicky;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
	
	@GetMapping("/home")
	public String index(Model model) {
		model.addAttribute("greetings", "Hello World by Thymeleaf");
		return "index";
	}
	
	@GetMapping("/home0")
	public String index1(Model model) {
		model.addAttribute("greetings", "Hello World by Thymeleaf");
		return "hi";
	}

}
