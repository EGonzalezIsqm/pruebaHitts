package com.example.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.api.ClienteRepository;

@Controller
@RequestMapping("/cliente")
public class ClienteControlador {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listaClientes(ModelMap map) {
		map.put("clientes", clienteRepository.findAll());
		return "cliente/lista";
	}
	
}
