package com.vicky;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/bs")
	public String index(Model model) {
		model.addAttribute("abcd", "Welcome to BootStrap-ThymeLeaf in Springboot APP");
		return "index";
	}

}
