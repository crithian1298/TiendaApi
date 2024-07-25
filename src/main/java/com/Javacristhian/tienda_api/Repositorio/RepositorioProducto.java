package com.Javacristhian.tienda_api.Repositorio;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Javacristhian.tienda_api.entity.Categoria;
import com.Javacristhian.tienda_api.entity.Productos;

@Repository
public interface RepositorioProducto extends JpaRepository<Productos, Long>{


	 List<Productos> findByNproducto(String nproducto);
	 	
	List<Productos> findByCategoria(Categoria categoria);
	 
	@Query(value="SELECT u FROM Productos u where  fechaf<now()")
	 List<Productos> findByFechaf();
	

}
