package edu.pe.idat.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import edu.pe.idat.model.Alumno;

public interface IAlumnoServicio {

	public List<Alumno> listar();
	
	public Optional<Alumno> listarPorId(int id);
	
	public int grabar(Alumno curso);
	
	public int actualizar(Alumno curso);
	
	public void eliminar(int id);
	
}
