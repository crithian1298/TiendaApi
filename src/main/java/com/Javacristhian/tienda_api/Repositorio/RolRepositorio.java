package com.Javacristhian.tienda_api.Repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Javacristhian.tienda_api.entity.rol;


public interface RolRepositorio extends JpaRepository<rol, Long>{
	
	public Optional<rol>findByNombre(String nombre);

}
