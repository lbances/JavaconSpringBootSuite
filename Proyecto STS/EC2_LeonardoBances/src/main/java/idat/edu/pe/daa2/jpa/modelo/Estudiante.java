/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package idat.edu.pe.daa2.jpa.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author lbances
 */
@Entity
@Table(name = "estudiante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e")
    , @NamedQuery(name = "Estudiante.findByIdEstudiante", query = "SELECT e FROM Estudiante e WHERE e.idEstudiante = :idEstudiante")
    , @NamedQuery(name = "Estudiante.findByNombre", query = "SELECT e FROM Estudiante e WHERE e.Nombre = :Nombre")
    , @NamedQuery(name = "Estudiante.findByApellidos", query = "SELECT e FROM Estudiante e WHERE e.Apellidos = :Apellidos")
    , @NamedQuery(name = "Estudiante.findByDni", query = "SELECT e FROM Estudiante e WHERE e.Dni = :Dni")
    , @NamedQuery(name = "Estudiante.findByCodigo_est", query = "SELECT e FROM Estudiante e WHERE e.Codigo_est = :Codigo_est")
    , @NamedQuery(name = "Estudiante.findByidGrado", query = "SELECT e FROM Estudiante e WHERE e.idGrado = :idGrado")})
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstudiante")
    private Integer idEstudiante;
    
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String Nombre;
    
    @Basic(optional = false)
    @Column(name = "Apellidos")
    private String Apellidos;
    
    @Basic(optional = false)
    @Column(name = "Dni")
    private Integer Dni;
    
    @Basic(optional = false)
    @Column(name = "Codigo_est")
    private String Codigo_est;
    
    @Basic(optional = false)
    @Column(name = "idGrado")
    private Integer idGrado;

    public Estudiante() {
    }

    public Estudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Estudiante(Integer idEstudiante, String Nombre, String Apellidos, Integer Dni, String Codigo_est, Integer idGrado) {
        this.idEstudiante = idEstudiante;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Dni = Dni;
        this.Codigo_est = Codigo_est;
        this.idGrado = idGrado;
        
    }
    
    public Integer getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(Integer idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public Integer getDni() {
		return Dni;
	}

	public void setDni(Integer dni) {
		Dni = dni;
	}

	public String getCodigo_est() {
		return Codigo_est;
	}

	public void setCodigo_est(String codigo_est) {
		Codigo_est = codigo_est;
	}

	public Integer getIdGrado() {
		return idGrado;
	}

	public void setIdGrado(Integer idGrado) {
		this.idGrado = idGrado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Apellidos, Codigo_est, Dni, Nombre, idEstudiante, idGrado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudiante other = (Estudiante) obj;
		return Objects.equals(Apellidos, other.Apellidos) && Objects.equals(Codigo_est, other.Codigo_est)
				&& Objects.equals(Dni, other.Dni) && Objects.equals(Nombre, other.Nombre)
				&& Objects.equals(idEstudiante, other.idEstudiante) && Objects.equals(idGrado, other.idGrado);
	}

	@Override
	public String toString() {
		return "Estudiante [idEstudiante=" + idEstudiante + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", Dni="
				+ Dni + ", Codigo_est=" + Codigo_est + ", idGrado=" + idGrado + "]";
	}
	
	
	
}
