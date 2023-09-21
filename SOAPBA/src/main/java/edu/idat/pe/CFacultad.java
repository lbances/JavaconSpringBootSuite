package edu.idat.pe;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="facultad")
public class CFacultad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codFacultad;
	
	private String desFacultad;
	
	public CFacultad() {
	
	}

	

	public CFacultad(int codFacultad, String desFacultad) {
		super();
		this.codFacultad = codFacultad;
		this.desFacultad = desFacultad;
	}



	public int getCodFacultad() {
		return codFacultad;
	}

	public void setCodFacultad(int codFacultad) {
		this.codFacultad = codFacultad;
	}

	public String getDesFacultad() {
		return desFacultad;
	}

	public void setDesFacultad(String desFacultad) {
		this.desFacultad = desFacultad;
	}
	
	
	
}
