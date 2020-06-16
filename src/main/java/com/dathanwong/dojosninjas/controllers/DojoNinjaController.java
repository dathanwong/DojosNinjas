package com.dathanwong.dojosninjas.controllers;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dathanwong.dojosninjas.models.Dojo;
import com.dathanwong.dojosninjas.models.Ninja;
import com.dathanwong.dojosninjas.services.DojoService;
import com.dathanwong.dojosninjas.services.NinjaService;

@Controller
public class DojoNinjaController {
	
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public DojoNinjaController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	@RequestMapping("/dojos/new")
	public String newDojoPage(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojoPage.jsp";
	}

	@RequestMapping("/ninjas/new")
	public String newNinjaPage(Model model, @ModelAttribute("ninja") Ninja ninja) {
		model.addAttribute("dojos", dojoService.findAll());
		return "newNinjaPage.jsp";
	}
	
	@PostMapping("/ninjas/new")
	public String newNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojos", dojoService.findAll());
			return "newNinjaPage.jsp";
		}else {
			ninjaService.create(ninja);
			return "redirect:/ninjas/new";
		}
	}
	
	@PostMapping("/dojos/new")
	public String newDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "newDojoPage.jsp";
		}else {
			dojoService.create(dojo);
			return "redirect:/dojos/"+dojo.getId();
		}
	}
	
	@RequestMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findById(id);
		model.addAttribute("dojo", dojo);
		return "showDojo.jsp";
	}
	
	@RequestMapping("/pages/{pageNumber}")
	public String getNinjasPerPage(Model model, @PathVariable("pageNumber") int pageNumber) {
		Page<Object[]> objects = ninjaService.findNinjaDojos(pageNumber-1);
//		Page<Ninja> ninjas = ninjaService.ninjasPerPage(pageNumber-1);
		int totalPages = objects.getTotalPages();
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("objects", objects);
//		model.addAttribute("ninjas", ninjas);
		return "ninjas.jsp";
	}
}
