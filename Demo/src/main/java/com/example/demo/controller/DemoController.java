package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
	
	@GetMapping
	public String hola() {
		return "Hola Mundo";
	}
	
	@GetMapping("saludo/{nombre}")
	public String saludo(@PathVariable("nombre") String nombre) {
		return "Hola " + nombre;
	}

}
