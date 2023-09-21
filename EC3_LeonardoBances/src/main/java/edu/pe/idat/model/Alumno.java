package edu.pe.idat.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Alumno")

public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotBlank
	@NotNull
	@NotEmpty
	private String codigo_alumno;
	
	@Column(name = "nombre", length = 60, nullable = false)
	@NotBlank
	@NotNull
	@NotEmpty
	private String nombre;
	
	@Column(name = "apellido_paterno")
	@NotBlank
	@NotNull
	@NotEmpty
	private String apellido_paterno;
	
	@Column(name = "apellido_materno")
	private String apellido_materno;
	
	@Column(name = "email")
	@Email
	@NotNull
	@NotEmpty
	private String email;
	
	@Column(name = "ciclo_actual")
	@NotBlank
	@NotNull
	@NotEmpty
	private int ciclo_actual;

	public Alumno() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Alumno(String codigo_alumno, String nombre, String apellido_paterno, String apellido_materno, String email,
			int ciclo_actual) {
		super();
		this.codigo_alumno = codigo_alumno;
		this.nombre = nombre;
		this.apellido_paterno = apellido_paterno;
		this.apellido_materno = apellido_materno;
		this.email = email;
		this.ciclo_actual = ciclo_actual;
	}

	public String getCodigo_alumno() {
		return codigo_alumno;
	}

	public void setCodigo_alumno(String codigo_alumno) {
		this.codigo_alumno = codigo_alumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido_paterno() {
		return apellido_paterno;
	}

	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}

	public String getApellido_materno() {
		return apellido_materno;
	}

	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCiclo_actual() {
		return ciclo_actual;
	}

	public void setCiclo_actual(int ciclo_actual) {
		this.ciclo_actual = ciclo_actual;
	}
	
	
	
}
