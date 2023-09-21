package idat.edu.pe.daa2.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.jpa.modelo.Estudiante;
import idat.edu.pe.daa2.jpa.modelo.Personal;
import idat.edu.pe.daa2.jpa.repositorios.EstudianteRepositorio;
import idat.edu.pe.daa2.jpa.repositorios.PersonalRepositorio;

@Service
@Transactional
public class PersonalServicio {

	@Autowired // Inyeccion de depencia
	public PersonalRepositorio personalRepositorio;
	
	public PersonalServicio() {
		
	}
	
	public List<Personal> listar(){
		return  (ArrayList<Personal>) PersonalServicio.findAll();
	}
	
	
	public Personal crear (Personal Personal) {
		return PersonalRepositorio.save(Personal);
	}
	
	
	
	public Personal actualizar(Personal personalActualizar) {
		
		Personal personalActual = PersonalRepositorio.findById(personalActualizar.getIdPersonal()).get();
		personalActual.setIdPersonal(personalActualizar.getIdPersonal());
		personalActual.setNombre(personalActualizar.getNombre());
		personalActual.setApellidos(personalActualizar.getApellidos());
		personalActual.setUsuario(personalActualizar.getUsuario());
		personalActual.setClave(personalActualizar.getClave());
		
		Estudiante personalActualizado = PersonalRepositorio.save(personalActual);
		return  personalActualizado;
		
	}
	
	public void eliminarPersonal(Integer IdPersonal) {
		personalRepositorio.deleteById(IdPersonal);
		
	}
}
