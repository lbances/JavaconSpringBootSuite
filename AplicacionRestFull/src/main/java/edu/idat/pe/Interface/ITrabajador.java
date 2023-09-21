package edu.idat.pe.Interface;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Modelo.CTrabajador;

@Repository
public interface ITrabajador extends CrudRepository<CTrabajador, Long>{
	Optional<CTrabajador> findBydoctra(String dni);
	Optional<CTrabajador> findByteltra(String telefono);
}
