package edu.pe.idat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.interfaces.IAlumnoRepositorio;

import edu.pe.idat.model.Alumno;
import edu.pe.idat.serviceinterfaces.IAlumnoServicio;

@Service
public class AlumnoServicio implements IAlumnoServicio {
	
	@Autowired
	private IAlumnoRepositorio alumnoRepositorio;
	
	@Override
	public List<Alumno> listar() {
		return (List<Alumno>) alumnoRepositorio.findAll();
	}

	@Override
	public Optional<Alumno> listarPorId(int id) {
		return alumnoRepositorio.findById(id);
	}

	@Override
	public int grabar(Alumno alumno) {
		int resultado = 0;
		Alumno alu = alumnoRepositorio.save(alumno);
		if (!alu.equals(null))
			resultado = 1;
		return resultado;
	}

	@Override
	public int actualizar(Alumno curso) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void eliminar(int id) {
		alumnoRepositorio.deleteById(id);
	}

}
