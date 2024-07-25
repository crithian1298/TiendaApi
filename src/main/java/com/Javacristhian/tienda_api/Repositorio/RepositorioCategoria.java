package com.Javacristhian.tienda_api.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Javacristhian.tienda_api.entity.Categoria;

public interface RepositorioCategoria extends JpaRepository<Categoria, Long> {

	
}
