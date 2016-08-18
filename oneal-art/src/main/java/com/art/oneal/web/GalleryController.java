package com.art.oneal.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.art.oneal.domain.ArtistRepository;

@RequestMapping("/gallery/**")
@Controller
public class GalleryController {
	
	@Autowired
	private ArtistRepository artistRepo;
	
	@RequestMapping("/")
    public String index(Model model) {
		if(artistRepo != null) //in the case of mock testing
			model.addAttribute("artists", artistRepo.findAll());
		return "gallery/index";
    }

}
