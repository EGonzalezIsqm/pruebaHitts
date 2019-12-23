package com.example.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vemtas")
public class Ventas implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idventas")
    private Integer id;	
	
	@Column(name = "nombreVenta")
	private String nombreVenta;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "productos_idproductos")
    private List<Productos> productosList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "clientes_idclientes")
    private List<Clientes> clientesList;

	public Ventas() {
		super();
	}

	public Ventas(Integer id, String nombreVenta, List<Productos> productosList, List<Clientes> clientesList) {
		super();
		this.id = id;
		this.nombreVenta = nombreVenta;
		this.productosList = productosList;
		this.clientesList = clientesList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreVenta() {
		return nombreVenta;
	}

	public void setNombreVenta(String nombreVenta) {
		this.nombreVenta = nombreVenta;
	}

	public List<Productos> getProductosList() {
		return productosList;
	}

	public void setProductosList(List<Productos> productosList) {
		this.productosList = productosList;
	}

	public List<Clientes> getClientesList() {
		return clientesList;
	}

	public void setClientesList(List<Clientes> clientesList) {
		this.clientesList = clientesList;
	}

	
}
