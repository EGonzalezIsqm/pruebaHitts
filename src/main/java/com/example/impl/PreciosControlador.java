package com.example.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.api.PreciosRepository;

@Controller
@RequestMapping("/precios")
public class PreciosControlador {

	@Autowired
	private PreciosRepository preciosRepository;
}
