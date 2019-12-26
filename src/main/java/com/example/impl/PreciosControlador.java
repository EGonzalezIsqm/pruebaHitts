package com.example.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.api.PreciosRepository;

@Controller
@RequestMapping("/precios")
public class PreciosControlador {

	@Autowired
	private PreciosRepository preciosRepository;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listaClientes(ModelMap map) {
		map.put("precios", preciosRepository.findAll());
		return "precios/lista";
	}
	
	
}
