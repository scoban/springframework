package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecuredController {

	@RequestMapping("/secured")
	public String enterSecuredArea(Model model) {
		model.addAttribute("name", "Selami");
		return "secured";
	}
}
