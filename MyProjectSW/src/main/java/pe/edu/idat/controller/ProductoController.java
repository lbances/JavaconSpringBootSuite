package pe.edu.idat.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.idat.model.Producto;
import pe.edu.idat.repository.ProductoRepository;

@RestController
@RequestMapping("/v1")
public class ProductoController {
	
	@Autowired
    private ProductoRepository repository;

	@GetMapping("/productos")
	public Collection<Producto> findAll(){
		return repository.findAll();
	}
	
	@GetMapping("/producto/{id_producto}")
	public Producto getById(@PathVariable("id_producto") Long id_producto) {
		return repository.findById(id_producto);
	}
	
	@PostMapping("/productoInsert")
	public Producto insert(@RequestBody Producto producto) {
		return repository.insert(producto);
	}
	
	@PutMapping("productoUpdate")
	public Producto update(@RequestBody Producto producto) {
		return repository.update(producto);
	}
	
	@DeleteMapping("/productoDelete/{id_producto}")
	public Producto delete(@PathVariable("id_producto") Long id_producto) {
		Producto producto = repository.findById(id_producto);
		repository.delete(id_producto);
		return producto;
	}
	
}
