package com.example.api;

import org.springframework.data.repository.CrudRepository;

import com.example.entidades.Productos;

public interface ProductosRepository extends CrudRepository<Productos, Integer>{

}
