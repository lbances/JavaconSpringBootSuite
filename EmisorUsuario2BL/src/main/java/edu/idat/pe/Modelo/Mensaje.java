package edu.idat.pe.Modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mensaje {

	String comentario;
	String tipo;
	
	LocalDateTime fechaHora = LocalDateTime.now();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String fechaHoraTexto = fechaHora.format(formatter);
    
	public Mensaje(String comentario, String tipo, String fechaHoraTexto) {
		super();
		this.comentario = comentario;
		this.tipo = tipo;
		this.fechaHoraTexto = fechaHoraTexto;
	}

	public Mensaje() {
		super();
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFechaHoraTexto() {
		return fechaHoraTexto;
	}

	public void setFechaHoraTexto(String fechaHoraTexto) {
		this.fechaHoraTexto = fechaHoraTexto;
	}

    
    
}
