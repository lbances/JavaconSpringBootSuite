package edu.idat.pe.Modelo;

public class Mensaje {

	String comentario;
	String tipo;
	
	public Mensaje(String comentario, String tipo) {
		this.comentario = comentario;
		this.tipo = tipo;
	}

	public Mensaje() {
	
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
	
	
}
