package com.art.oneal.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.art.oneal.domain.Artist;
import com.art.oneal.domain.ArtistRepository;

@RequestMapping("/artist/**")
@Controller
public class ArtistController {
	
	@Autowired
	private ArtistRepository artistRepo;	

	@RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(Model model) {
		if(artistRepo != null) //in the case of mock testing
			model.addAttribute("artists", artistRepo.findAll());		
		return "artist/list";
    }
	
	@RequestMapping("/create")
    public String createForm(Model model) {
		Artist artist = new Artist();
		model.addAttribute("artist", artist);
        return "artist/create";
    }
	
	@RequestMapping(path = "/", method = RequestMethod.POST)
    public String create(@Valid Artist artist, BindingResult bindingResult, Model model, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("artist", artist);
            return "artist/create";
        }
        model.asMap().clear(); 
        artistRepo.save(artist);
		if(artistRepo != null) //in the case of mock testing
			model.addAttribute("artists", artistRepo.findAll());		
		return "redirect:/artist";
    }	
	
}
