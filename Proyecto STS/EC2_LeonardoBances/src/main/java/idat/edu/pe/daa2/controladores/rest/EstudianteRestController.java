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
import idat.edu.pe.daa2.jpa.modelo.Estudiante;
import idat.edu.pe.daa2.servicios.EstudianteServicio;

@RestController
@RequestMapping("/rest/estudiante")
public class EstudianteRestController {

	@Autowired
	private EstudianteServicio servicio;
	
	@GetMapping
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> crear (@RequestBody Estudiante estudiante){
		servicio.crear(estudiante);
		return new ResponseEntity<Object> ("Estudiante creado correctamente", HttpStatus.OK);
	}

	public ResponseEntity<Object> listar(){
		List<Estudiante> listaEstudiante = servicio.listar();
		return new ResponseEntity<>(listaEstudiante, HttpStatus.OK);
	}
	
	 @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
		public ResponseEntity<Object> actualizar(@PathVariable("idEstudiante") int idEstudiante, @RequestBody Estudiante estudiante){
			servicio.actualizar(estudiante);
			return new ResponseEntity<Object>("Estudiante actualizado correctamente", HttpStatus.OK);
		}
	 
		@DeleteMapping(value = "/{idEstudiante}")
		public ResponseEntity<Object> eliminar (@PathVariable("idEstudiante") int idEstudiante){
		servicio.eliminarEstudiante(idEstudiante);
		return new ResponseEntity<Object> ("Estudiante eliminado correctamente", HttpStatus.OK);
		}
}
