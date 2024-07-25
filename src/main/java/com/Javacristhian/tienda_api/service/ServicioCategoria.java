package com.Javacristhian.tienda_api.service;

import com.Javacristhian.tienda_api.entity.Categoria;


public interface ServicioCategoria {

	public Iterable<Categoria> findAll();
	public Categoria save(Categoria categoria);
}
