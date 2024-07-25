package com.Javacristhian.tienda_api.controler;




import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import java.util.stream.StreamSupport;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Javacristhian.tienda_api.ExceptionMessage.RecursoNotFoundsException;
import com.Javacristhian.tienda_api.entity.Categoria;
import com.Javacristhian.tienda_api.entity.Productos;
import com.Javacristhian.tienda_api.service.ServicioProducto;


@RestController
@RequestMapping("producto")

public class ProductoRest {

	@Autowired
	private ServicioProducto servicioproducto;
	@GetMapping
	public List<Productos> readAll(){
		
		List<Productos> productos = StreamSupport.stream(servicioproducto.findAll().spliterator(), false).collect(Collectors.toList());
		
		return productos;
		
	}
	@RequestMapping(value="{idproducto}")
	public ResponseEntity<Productos>getProductoById(@PathVariable("idproducto")Long idproducto){
		
		Optional<Productos>optionalProduct=servicioproducto.findById(idproducto);
		if(optionalProduct.isPresent()) {
			
			return ResponseEntity.ok(optionalProduct.get());
			
		}
		else {
			
			return ResponseEntity.noContent().build();
		}
	}
	

	@GetMapping("/filtrarfecha")
	public ResponseEntity<List<Productos>> getfindByfechaf(){
		List<Productos> fecha = servicioproducto.findByFechaf();
	     
		return ResponseEntity.ok(fecha);
		
	 
	}
	

	@GetMapping("/filtrocategoria")
	public ResponseEntity<List<Productos>> findByCategoria(@RequestParam Long idcategoria){
		List<Productos>producto=new ArrayList<>();
		if(idcategoria==null) {
			
			 producto = StreamSupport.stream(servicioproducto.findAll().spliterator(), false).collect(Collectors.toList());
		}
		
		else {
			
			producto=servicioproducto.findByCategoria(Categoria.builder().id(idcategoria).build());
		}
		if(producto.isEmpty()) {
			return ResponseEntity.noContent().build();
			
		}
		
	 
		
		return ResponseEntity.ok(producto);
	}
	
	@GetMapping("/filtronombre")
	public ResponseEntity<List<Productos>> getfindByNproducto(@RequestParam String nproducto){
		return new ResponseEntity<List<Productos>>(servicioproducto.getfindByNproducto(nproducto),HttpStatus.OK);
	}
	
	

	@PostMapping("/guardar")
	public ResponseEntity<Productos> save(@Valid @RequestBody Productos productos){
	
		return new ResponseEntity<>(servicioproducto.save(productos),HttpStatus.CREATED);

	}
	
	
	@DeleteMapping(value="{eliminarproductoid}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("eliminarproductoid")Long idproducto) {
	
		servicioproducto.deleteById(idproducto);
		
				return ResponseEntity.ok(null);			
	}
	
	@PutMapping()
	public ResponseEntity<Productos> updateProducto(@RequestBody Productos productos){
	Optional<Productos> optionalProducto= servicioproducto.findById(productos.getIdproducto());
		
		if(optionalProducto.isPresent()) {
			Productos updateProductos= optionalProducto.get();
			
			
			updateProductos.setNempresa(productos.getNempresa());
			updateProductos.setDescripcion(productos.getDescripcion());
			updateProductos.setFechaf(productos.getFechaf());
			updateProductos.setFechai(productos.getFechai());
			updateProductos.setNproducto(productos.getNproducto());
			updateProductos.setStock(productos.getStock());
			
			servicioproducto.save(updateProductos);
			return ResponseEntity.ok(updateProductos);	
		}else {
			
			return ResponseEntity.noContent().build();	
		}
	}
	
}
