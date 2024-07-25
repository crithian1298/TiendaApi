package com.Javacristhian.tienda_api.controler;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Javacristhian.tienda_api.entity.Categoria;

import com.Javacristhian.tienda_api.service.ServicioCategoria;

@RestController
@RequestMapping("categoria")
public class CategoriaRest {
	
	@Autowired
	
	ServicioCategoria servicioCategoria;
	
	@GetMapping
	public List<Categoria> readAll(){
		
		List<Categoria> productos = StreamSupport.stream(servicioCategoria.findAll().spliterator(), false).collect(Collectors.toList());
		
		return productos;
		
	}
	@PostMapping
	public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria){
		
				
				return new ResponseEntity<>(servicioCategoria.save(categoria),HttpStatus.CREATED);
	}
	
	

}
