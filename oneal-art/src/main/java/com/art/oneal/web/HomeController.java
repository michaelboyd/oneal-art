package com.art.oneal.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	private final String WELCOME_MESSAGE = "Welcome to Oneal's Art Gallery";

	@RequestMapping("/")
    public String index(@RequestParam(value="name", required=false, defaultValue="Sir") String name, Model model) {
        model.addAttribute("welcome_message", WELCOME_MESSAGE);
        return "index";
    }
	
	@RequestMapping("/login")
    public String login(@RequestParam(value="logout", required=false) String logout, Model model) {
		String view = "login";
		if(logout != null) {
			model.addAttribute("welcome_message", WELCOME_MESSAGE);
			view = "index";
		}
		return view;
    }
	
	
}
