package com.Javacristhian.tienda_api.entity;

import java.util.Calendar;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Productos {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idproducto;
	
	@Column(name="fechaf",nullable = false)
    @Temporal(TemporalType.DATE)
	private Calendar fechaf;
	
	@Column(name="fechai",nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar fechai;
	
	
@Column(name="nempresa",nullable = false)
@NotEmpty
@Size(min=5,message="el Nombre de la empresa debe tener 5 caracteres como minimo")
	private String nempresa;
	
@NotEmpty
@Size(min=5,message="El Nombre del producto  debe tener 5 caracteres como minimo")
	private String nproducto;
	
	
	
	@ManyToOne
	@JoinColumn(name="categoria_id",nullable = false)
		private Categoria categoria;

	
	
	@Column(name="descripcion",nullable = false)
	@NotEmpty
	@Size(min=10,message="La descripcion debe tener 10 caracteres como minimo")
	private String descripcion;
	
	@Column(name="stock",nullable = false)
	private Integer stock;
	
	
	
}
