package com.Javacristhian.tienda_api.service;


import java.util.List;
import java.util.Optional;



import com.Javacristhian.tienda_api.entity.Categoria;
import com.Javacristhian.tienda_api.entity.Productos;

public interface ServicioProducto {

	public Iterable<Productos> findAll();
	
	 List<Productos> getfindByNproducto(String nproducto);
	 
	 List<Productos> findByFechaf();
	 List<Productos> findByCategoria(Categoria categoria);
	
	public Optional<Productos> findById(Long idproducto);	
	
	public Productos save(Productos productos);
	
	public void deleteById(Long idproducto);
	
	
		
	
}
