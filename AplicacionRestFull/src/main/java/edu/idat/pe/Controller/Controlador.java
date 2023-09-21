package edu.idat.pe.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Modelo.CTrabajador;
import edu.idat.pe.Service.ServiceTrabajador;

@RestController
@RequestMapping("/Trabajador")
public class Controlador {
	
	@Autowired
	private ServiceTrabajador st;
	
	@GetMapping()
	public List<CTrabajador> listartrabajadores(){
		return st.listartrabajadores();
	}
	
	@GetMapping("telefono/{teltra}")
	public Optional<CTrabajador> buscarportelefono(@PathVariable String teltra){
		return st.buscarportelefono(teltra);
	}
	
	@GetMapping("documento/{doctra}")
	public Optional<CTrabajador> buscarpordni(@PathVariable String doctra){
		return st.buscarpordni(doctra);
	}
	
	@PostMapping()
	public CTrabajador guardartrabajador(@RequestBody CTrabajador t) {
		return st.guardartrabajador(t);
	}
	
	@DeleteMapping("/{doctra}")
	public String eliminartrabajador(@PathVariable String doctra) {
		boolean res = st.eliminartrabajador(doctra);
		if (res) {
			return "Eliminó el registro del trabajador con DNI: "+doctra;
		}
		else {
			return "No se pudo eliminar el registro del trabajdor con DNI: "+doctra;
		}
	}
	
	@PutMapping()
	public String actualizartrabajador(@RequestBody CTrabajador t) {
		boolean res = st.buscarporcodigo(t.getCodtra());
		if (res) {
			CTrabajador ob = st.buscarporcodigo2(t.getCodtra());
			if (t.getApetra() == null)t.setApetra(ob.getApetra());
			if (t.getNomtra() == null)t.setNomtra(ob.getNomtra());
			if (t.getDirtra() == null)t.setDirtra(ob.getDirtra());
			if (t.getDoctra() == null)t.setDoctra(ob.getDoctra());
			if (t.getEsttra() == null)t.setEsttra(ob.getEsttra());
			if (t.getEsttra() == null)t.setEsttra(ob.getEsttra());
			if (t.getCortra() == null)t.setCortra(ob.getCortra());
			if (t.getTeltra() == null)t.setTeltra(ob.getTeltra());
			st.actualizartrabajador(t);
			return "Se actualizaron los datos de trabajador correctamente.";
				
			}
		else {
			return "No se pude actualizar los datos del trabajador";
		}
	}
	
}
