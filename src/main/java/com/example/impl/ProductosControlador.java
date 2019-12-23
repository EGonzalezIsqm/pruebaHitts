package com.example.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.api.ProductosRepository;

@Controller
@RequestMapping("/productos")
public class ProductosControlador {

	@Autowired
	private ProductosRepository productosRepository;
}
