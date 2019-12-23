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
@Table(name = "productos")
public class Productos  implements Serializable {

    private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idproductos")
    private Integer id;	
	
	@Column(name = "nombreProducto")
	private String nombreProductos;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "precios_idprecios")
    private List<Precios> preciosList;

	
	public Productos() {
		super();
	}

	public Productos(Integer id, String nombreProductos, List<Precios> preciosList) {
		super();
		this.id = id;
		this.nombreProductos = nombreProductos;
		this.preciosList = preciosList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreProductos() {
		return nombreProductos;
	}

	public void setNombreProductos(String nombreProductos) {
		this.nombreProductos = nombreProductos;
	}

	public List<Precios> getPreciosList() {
		return preciosList;
	}

	public void setPreciosList(List<Precios> preciosList) {
		this.preciosList = preciosList;
	}
	
	
}
