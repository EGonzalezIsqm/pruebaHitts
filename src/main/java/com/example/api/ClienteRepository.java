package com.example.api;

import org.springframework.data.repository.CrudRepository;

import com.example.entidades.Clientes;

public interface ClienteRepository extends CrudRepository<Clientes, Integer>{

}
