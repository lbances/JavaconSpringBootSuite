package edu.idat.pe;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServicioFacultad {

	private IFacultad ifacultad;
	
	@Autowired
	public ServicioFacultad(IFacultad ifacultad) {
		this.ifacultad = ifacultad;
	}
	
	public CFacultad buscarcodigo(int cod) {
		return ifacultad.findById(cod).get();
	}
	
	public List<CFacultad> listarfacultades(){
		List<CFacultad> lista = new ArrayList<>();
		ifacultad.findAll().forEach(e->lista.add(e));
		return lista;
	}
	
	public CFacultad guardarproducto(CFacultad facultad) {
		try {
			return ifacultad.save(facultad);
		} catch (Exception e) {
			return null;
		}
	}
	
	public boolean eliminarfacultad(int codigo) {
		boolean sw = false;
		try {
			sw = ifacultad.findById(codigo).isPresent();
			if(sw)ifacultad.deleteById(codigo);
		} catch (Exception e) {
			return false;
		}
		return sw;
	}
	
}
