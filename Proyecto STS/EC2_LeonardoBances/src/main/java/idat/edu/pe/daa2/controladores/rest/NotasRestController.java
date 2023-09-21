package idat.edu.pe.daa2.controladores.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import idat.edu.pe.daa2.jpa.modelo.Notas;
import idat.edu.pe.daa2.servicios.NotasServicio;

@RestController
@RequestMapping("/rest/notas")
public class NotasRestController {

	@Autowired
	private NotasServicio servicio;
	
	@GetMapping
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> crear (@RequestBody Notas notas){
		servicio.crear(notas);
		return new ResponseEntity<Object> ("Notas creada correctamente", HttpStatus.OK);
	}

	public ResponseEntity<Object> listar(){
		List<Notas> listaNotas = servicio.listar();
		return new ResponseEntity<>(listaNotas, HttpStatus.OK);
	}
	
	 @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
		public ResponseEntity<Object> actualizar(@PathVariable("idNotas") int idNotas, @RequestBody Notas notas){
			servicio.actualizar(notas);
			return new ResponseEntity<Object>("Nota actualizada correctamente", HttpStatus.OK);
		}
	 
		@DeleteMapping(value = "/{idNotas}")
		public ResponseEntity<Object> eliminar (@PathVariable("idNotas") int idNotas){
		servicio.eliminarNotas(idNotas);
		return new ResponseEntity<Object> ("Nota eliminada correctamente", HttpStatus.OK);
		}
}
