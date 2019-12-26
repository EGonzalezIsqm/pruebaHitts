package com.example.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.api.ClienteRepository;
import com.example.entidades.Clientes;
import com.example.entidades.Ventas;

@Controller
@RequestMapping("/cliente")
public class ClienteControlador {

	@Autowired
	private ClienteRepository clienteRepository;

	@PostMapping("/agregarcliente")
	public String agregar(@Valid Clientes cliente, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "agregar-cliente";
		}

		clienteRepository.save(cliente);
		model.addAttribute("clientes", clienteRepository.findAll());
		return "index";
	}

	@GetMapping("/edit/{id}")
	public String cargarFormulario(@PathVariable("id") Integer id, Model model) {
		Clientes clientes = clienteRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id del cliente incorrecto:" + id));

		model.addAttribute("clientes", clientes);
		return "editar-cliente";
	}

	@PostMapping("/editarcliente/{id}")
	public String editar(@PathVariable("id") Integer id, @Valid Clientes cliente, BindingResult result, Model model) {
		if (result.hasErrors()) {
			cliente.setId(id);
			return "editar-cliente";
		}

		clienteRepository.save(cliente);
		model.addAttribute("clientes", clienteRepository.findAll());
		return "index";
	}

	@GetMapping("/eliminarcliente/{id}")
	public String eliminar(@PathVariable("id") Integer id, Model model) {
		Clientes clientes = clienteRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id del cliente incorrecto:" + id));
		clienteRepository.delete(clientes);
		model.addAttribute("clientes", clienteRepository.findAll());
		return "index";
	}

}
