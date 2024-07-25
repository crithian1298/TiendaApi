package com.Javacristhian.tienda_api.Repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Javacristhian.tienda_api.entity.usuario;

public interface UsuarioRepositorio extends JpaRepository<usuario, Long> {
	
	Optional<usuario> findByEmail(String email);
	Optional<usuario> findByUsernameOrEmail(String username, String email);
	Optional<usuario> findByUsername(String username);
	Boolean existsByusername(String username);
	Boolean existsByemail(String email);
}
