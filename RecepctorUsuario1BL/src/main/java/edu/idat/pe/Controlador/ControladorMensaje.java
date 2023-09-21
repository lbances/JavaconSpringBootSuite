package edu.idat.pe.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.idat.pe.Modelo.Mensaje;
import jakarta.jms.Queue;

@RestController
public class ControladorMensaje {

	@Autowired
	JmsTemplate p;
	
	@GetMapping("/Leeusuario1")
	public ResponseEntity<Mensaje> leermensaje(){
		try {
			p.setReceiveTimeout(1000);
			Mensaje ob = (Mensaje) p.receiveAndConvert("Usuario2");			
			return new ResponseEntity<Mensaje>(ob, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}