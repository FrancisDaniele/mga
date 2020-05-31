package com.gourmet.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class RestaurantesAppController {
	
	@GetMapping("/restaurantes")
	public String mostrarListaView(){
		return "listRestaurantes";
	}
	@GetMapping("/admin")
	public String mostrarAdmin(){
		return "admin/index";
	}

}