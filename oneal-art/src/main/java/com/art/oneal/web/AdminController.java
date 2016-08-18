package com.art.oneal.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/**")
@Controller
public class AdminController {
	
	@RequestMapping("/")
    public String index(Model model) {
		return "admin/index";
    }
	
	

}
