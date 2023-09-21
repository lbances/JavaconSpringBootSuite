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
import idat.edu.pe.daa2.jpa.modelo.Personal;
import idat.edu.pe.daa2.servicios.PersonalServicio;

@RestController
@RequestMapping("/rest/personal")
public class PersonalRestController {

	@Autowired
	private PersonalServicio servicio;
	
	@GetMapping
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> crear (@RequestBody Personal personal){
		servicio.crear(personal);
		return new ResponseEntity<Object> ("Personal creado correctamente", HttpStatus.OK);
	}

	public ResponseEntity<Object> listar(){
		List<Personal> listaPersonal = servicio.listar();
		return new ResponseEntity<>(listaPersonal, HttpStatus.OK);
	}
	
	 @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
		public ResponseEntity<Object> actualizar(@PathVariable("idPersonal") int idPersonal, @RequestBody Personal personal){
			servicio.actualizar(personal);
			return new ResponseEntity<Object>("Personal actualizado correctamente", HttpStatus.OK);
		}
	 
		@DeleteMapping(value = "/{idPersonal}")
		public ResponseEntity<Object> eliminar (@PathVariable("idPersonal") int idPersonal){
		servicio.eliminarPersonal(idPersonal);
		return new ResponseEntity<Object> ("Personal eliminado correctamente", HttpStatus.OK);
		}
}