package com.example.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.api.VentasRepository;
import com.example.entidades.Ventas;

@Controller
@RequestMapping("/ventas")
public class VentasControlador {

	@Autowired
	private VentasRepository ventasRepository;
	
	@PostMapping("/agregarventa")
	public String agregar(@Valid Ventas ventas, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "agregar-venta";
		}

		ventasRepository.save(ventas);
		model.addAttribute("ventas", ventasRepository.findAll());
		return "index";
	}

	@GetMapping("/edit/{id}")
	public String cargarFormulario(@PathVariable("id") Integer id, Model model) {
		Ventas ventas = ventasRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id de la venta es incorrecto::" + id));

		model.addAttribute("ventas", ventas);
		return "editar-venta";
	}

	@PostMapping("/editarventa/{id}")
	public String editar(@PathVariable("id") Integer id, @Valid Ventas ventas, BindingResult result, Model model) {
		if (result.hasErrors()) {
			ventas.setId(id);
			return "editar-venta";
		}

		ventasRepository.save(ventas);
		model.addAttribute("ventas", ventasRepository.findAll());
		return "index";
	}

	@GetMapping("/eliminarventa/{id}")
	public String eliminar(@PathVariable("id") Integer id, Model model) {
		Ventas ventas = ventasRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id de la venta es incorrecto:" + id));
		ventasRepository.delete(ventas);
		model.addAttribute("ventas", ventasRepository.findAll());
		return "index";
	}
}
