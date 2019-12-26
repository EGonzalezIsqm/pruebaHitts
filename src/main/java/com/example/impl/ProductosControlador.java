package com.example.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.api.ProductosRepository;

@Controller
@RequestMapping("/productos")
public class ProductosControlador {

	@Autowired
	private ProductosRepository productosRepository;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listaClientes(ModelMap map) {
		map.put("productos", productosRepository.findAll());
		return "productos/lista";
	}
}
