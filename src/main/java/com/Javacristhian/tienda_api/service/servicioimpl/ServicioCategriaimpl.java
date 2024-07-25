package com.Javacristhian.tienda_api.service.servicioimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Javacristhian.tienda_api.Repositorio.RepositorioCategoria;
import com.Javacristhian.tienda_api.entity.Categoria;
import com.Javacristhian.tienda_api.service.ServicioCategoria;

@Service
public class ServicioCategriaimpl implements ServicioCategoria {

	@Autowired
	
	RepositorioCategoria repositorioCategoria;
	
	@Override
	public Iterable<Categoria> findAll() {

		return repositorioCategoria.findAll();
	}

	@Override
	public Categoria save(Categoria categoria) {
		// TODO Auto-generated method stub
		return repositorioCategoria.save(categoria);
	}

}
