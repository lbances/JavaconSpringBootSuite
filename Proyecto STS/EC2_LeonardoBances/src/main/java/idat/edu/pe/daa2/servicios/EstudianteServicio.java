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
public class EstudianteServicio {

	@Autowired // Inyeccion de depencia
	public EstudianteRepositorio estudianteRepositorio;
	
	public EstudianteServicio() {
		
	}
	
	public List<Estudiante> listar(){
		return  (ArrayList<Estudiante>) EstudianteServicio.findAll();
	}
	
	
	public Estudiante crear (Estudiante Estudiante) {
		return EstudianteRepositorio.save(Estudiante);
	}
	
	
	
	public Estudiante actualizar(Estudiante estudianteActualizar) {
		
		Estudiante estudianteActual = EstudianteRepositorio.findById(estudianteActualizar.getIdEstudiante()).get();
		estudianteActual.setIdEstudiante(estudianteActualizar.getIdEstudiante());
		estudianteActual.setNombre(estudianteActualizar.getNombre());
		estudianteActual.setApellidos(estudianteActualizar.getApellidos());
		estudianteActual.setDni(estudianteActualizar.getDni());
		estudianteActual.setCodigo_est(estudianteActualizar.getCodigo_est());
		estudianteActual.setIdGrado(estudianteActualizar.getIdGrado());
		
		Estudiante estudianteActualizado = EstudianteRepositorio.save(estudianteActual);
		return  estudianteActualizado;
		
	}
	
	public void eliminarEstudiante(Integer IdEstudiante) {
		estudianteRepositorio.deleteById(IdEstudiante);
		
	}
}
