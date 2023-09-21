package edu.idat.pe.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Modelo.CTrabajador;
import edu.idat.pe.Interface.ITrabajador;

@Service
public class ServiceTrabajador {

	@Autowired
	private ITrabajador itrab;
	
	public List<CTrabajador> listartrabajadores(){
		return (List<CTrabajador>)itrab.findAll();
	}
	
	public CTrabajador guardartrabajador(CTrabajador t) {
		Optional<CTrabajador> trab = itrab.findBydoctra(t.getDoctra());
		if(!trab.isPresent()) {
			return itrab.save(t);
		}
		else {
			return null;
		}
	}
	
	public Optional<CTrabajador> buscarpordni(String dni){
		return itrab.findBydoctra(dni);
	}
	
	public Optional<CTrabajador> buscarportelefono(String telefono){
		return itrab.findByteltra(telefono);
	}
	
	public boolean eliminartrabajador(String dni) {
		try {
			Optional<CTrabajador> trab = itrab.findBydoctra(dni);
			if(!trab.isPresent()) {
				itrab.deleteById(trab.get().getCodtra());
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		
		return false;
	}
	
	public CTrabajador actualizartrabajador(CTrabajador t) {
		return itrab.save(t);
	}
	
	public boolean buscarporcodigo(long codigo) {
		Optional<CTrabajador> t = itrab.findById(codigo);
		if (t.isPresent()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public CTrabajador buscarporcodigo2(long codigo) {
		return itrab.findById(codigo).get();
	}
}
