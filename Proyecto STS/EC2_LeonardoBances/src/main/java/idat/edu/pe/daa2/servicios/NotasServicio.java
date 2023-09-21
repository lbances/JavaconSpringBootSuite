package idat.edu.pe.daa2.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.jpa.modelo.Estudiante;
import idat.edu.pe.daa2.jpa.modelo.Notas;
import idat.edu.pe.daa2.jpa.modelo.Personal;
import idat.edu.pe.daa2.jpa.repositorios.EstudianteRepositorio;
import idat.edu.pe.daa2.jpa.repositorios.NotasRepositorio;
import idat.edu.pe.daa2.jpa.repositorios.PersonalRepositorio;

@Service
@Transactional
public class NotasServicio {

	@Autowired // Inyeccion de depencia
	public NotasRepositorio notasRepositorio;
	
	public NotasServicio() {
		
	}
	
	public List<Notas> listar(){
		return  (ArrayList<Notas>) NotasServicio.findAll();
	}
	
	
	public Notas crear (Notas Notas) {
		return NotasRepositorio.save(Notas);
	}
	
	
	
	public Notas actualizar(Notas notasActualizar) {
		
		Notas notasActual = NotasRepositorio.findById(notasActualizar.getIdNotas()).get();
		notasActual.setIdNotas(notasActualizar.getIdNotas());
		notasActual.setNota1(notasActualizar.getNota1());
		notasActual.setNota2(notasActualizar.getNota2());
		notasActual.setNota3(notasActualizar.getNota3());
		notasActual.setNota4(notasActualizar.getNota4());
		notasActual.setPromedio(notasActualizar.getPromedio());
		notasActual.setIdPeriodo(notasActualizar.getIdPeriodo());
		
		Notas notasActualizado = NotasRepositorio.save(notasActual);
		return  notasActualizado;
		
	}
	
	public void eliminarNotas(Integer IdNotas) {
		notasRepositorio.deleteById(IdNotas);
		
	}
}
