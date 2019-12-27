package com.example.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.api.PreciosRepository;
import com.example.entidades.Precios;

@Controller
public class PreciosControlador {

	@Autowired
	private PreciosRepository preciosRepository;
	
	@PostMapping("/agregarprecio")
	public String agregar(@Valid Precios precios, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "agregar-precio";
		}

		preciosRepository.save(precios);
		model.addAttribute("precios", preciosRepository.findAll());
		return "precio/lista";
	}

	@GetMapping("/edit/{id}")
	public String cargarFormulario(@PathVariable("id") Integer id, Model model) {
		Precios precios = preciosRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id del precio incorrecto:" + id));

		model.addAttribute("precios", precios);
		return "editar-precios";
	}

	@PostMapping("/editarprecio/{id}")
	public String editar(@PathVariable("id") Integer id, @Valid Precios precios, BindingResult result, Model model) {
		if (result.hasErrors()) {
			precios.setId(id);
			return "editar-precio";
		}

		preciosRepository.save(precios);
		model.addAttribute("clientes", preciosRepository.findAll());
		return "precio/lista";
	}

	@GetMapping("/eliminarprecio/{id}")
	public String eliminar(@PathVariable("id") Integer id, Model model) {
		Precios precios = preciosRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id del precios incorrecto:" + id));
		preciosRepository.delete(precios);
		model.addAttribute("precios", preciosRepository.findAll());
		return "precio/lista";
	}
	
	
}
