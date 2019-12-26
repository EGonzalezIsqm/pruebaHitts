package com.example.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.api.VentasRepository;

@Controller
@RequestMapping("/ventas")
public class VentasControlador {

	@Autowired
	private VentasRepository ventasRepository;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listaClientes(ModelMap map) {
		map.put("ventas", ventasRepository.findAll());
		return "ventas/lista";
	}
}
