package edu.idat.pe.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.idat.pe.Modelo.Mensaje;
import jakarta.jms.Queue;

@RestController
public class ControladorMensaje {

	@Autowired
	JmsTemplate p;
	
	@PostMapping("/mensaje")
	public ResponseEntity<Mensaje> enviarmensaje(@RequestBody Mensaje m){
		try {
			Queue cola = p.getConnectionFactory().createConnection().createSession().createQueue("Usuario1");
			
			Mensaje ob = new Mensaje(m.getComentario(), m.getTipo() + "[USUARIO1]");
			p.convertAndSend(cola, ob);
			return new ResponseEntity<Mensaje>(ob, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
