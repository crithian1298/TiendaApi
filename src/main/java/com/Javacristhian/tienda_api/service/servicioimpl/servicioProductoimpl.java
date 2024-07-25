package com.Javacristhian.tienda_api.service.servicioimpl;





import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.Javacristhian.tienda_api.ExceptionMessage.RecursoNotFoundsException;
import com.Javacristhian.tienda_api.Repositorio.RepositorioProducto;
import com.Javacristhian.tienda_api.entity.Categoria;
import com.Javacristhian.tienda_api.entity.Productos;
import com.Javacristhian.tienda_api.service.ServicioProducto;


@Service

public class servicioProductoimpl implements ServicioProducto {
	@Autowired
	private RepositorioProducto repositorioproducto;
	



	@Override
	public Optional<Productos> findById(Long idproducto) {
	
			
	Productos producto=repositorioproducto.findById(idproducto).orElseThrow(()->new RecursoNotFoundsException("Productos","idproducto", idproducto));
		
	
			
		return Optional.of(producto);
		
	
	}

	@Override
	public Productos save(Productos productos) {
		// TODO Auto-generated method stub
		return repositorioproducto.save(productos);
	}

	@Override
	public void deleteById(Long idproducto) {
		
	repositorioproducto.findById(idproducto).orElseThrow(()->new RecursoNotFoundsException("Productos","idproducto", idproducto));

		
	}

	@Override
	public Iterable<Productos> findAll() {
	
		return repositorioproducto.findAll();
	}

	@Override
	public  List<Productos> getfindByNproducto(String nproducto) {
		
		return repositorioproducto.findByNproducto(nproducto);
	}

	
	@Override
	public List<Productos> findByCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return repositorioproducto.findByCategoria(categoria);
	}

	@Override
	public List<Productos> findByFechaf() {
		
		return repositorioproducto.findByFechaf();
	}


		
}



