package com.example.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.api.ProductosRepository;
import com.example.entidades.Productos;

@Controller
public class ProductosControlador {

	@Autowired
	private ProductosRepository productosRepository;

	@PostMapping("/agregarproducto")
	public String agregarProducto(@Valid Productos productos, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "agregar-producto";
		}

		productosRepository.save(productos);
		model.addAttribute("producto", productosRepository.findAll());
		return "productos/lista";
	}

	@GetMapping("/edit/{id}")
	public String cargarFormulario(@PathVariable("id") Integer id, Model model) {
		Productos productos = productosRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id del producto incorrecto:" + id));

		model.addAttribute("productos", productos);
		return "editar-producto";
	}

	@PostMapping("/editarproducto/{id}")
	public String editar(@PathVariable("id") Integer id, @Valid Productos productos, BindingResult result, Model model) {
		if (result.hasErrors()) {
			productos.setId(id);
			return "editar-producto";
		}

		productosRepository.save(productos);
		model.addAttribute("productos", productosRepository.findAll());
		return "productos/lista";
	}

	@GetMapping("/eliminarproducto/{id}")
	public String eliminar(@PathVariable("id") Integer id, Model model) {
		Productos productos = productosRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id del producto incorrecto:" + id));
		productosRepository.delete(productos);
		model.addAttribute("productos", productosRepository.findAll());
		return "productos/lista";
	}

}
