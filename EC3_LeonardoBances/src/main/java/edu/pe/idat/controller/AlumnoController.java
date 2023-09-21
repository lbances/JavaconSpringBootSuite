package edu.pe.idat.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.pe.idat.model.Alumno;
import edu.pe.idat.serviceinterfaces.IAlumnoServicio;



@Controller
@RequestMapping("/alumno")

public class AlumnoController {

	@Autowired
	private IAlumnoServicio alumnoServicio;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Alumno> listaAlumnos = alumnoServicio.listar();
		model.addAttribute("alumno", listaAlumnos);
		return "Alumno/index";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(@Validated Model model, BindingResult bindinResult) {
		if(bindinResult.hasErrors()) {
			return "Alumno/index";
		}
		model.addAttribute("alumno", new Alumno());
		return "Alumno/form-alumno";
	}
	
	@PostMapping("/grabar")
	public String grabar(Alumno alu, Model model) {
		alumnoServicio.grabar(alu);
		return "redirect:listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Alumno> alumno = alumnoServicio.listarPorId(id);
		model.addAttribute("alumno", alumno);
		return "Alumno/form-alumno";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id, Model mode) {
		alumnoServicio.eliminar(id);
		return "redirect:/alumno/listar";
	}
	
}
