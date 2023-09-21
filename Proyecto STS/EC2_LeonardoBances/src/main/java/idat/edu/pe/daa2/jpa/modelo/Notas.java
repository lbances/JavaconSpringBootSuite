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
@Table(name = "notas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notas.findAll", query = "SELECT n FROM Notas n")
    , @NamedQuery(name = "Notas.findByIdNota", query = "SELECT n FROM Notas n WHERE n.idNota = :idNota")
    , @NamedQuery(name = "Notas.findByNota1", query = "SELECT n FROM Notas n WHERE n.Nota1 = :Nota1")
    , @NamedQuery(name = "Notas.findByNota2", query = "SELECT n FROM Notas n WHERE n.Nota2 = :Nota2")
    , @NamedQuery(name = "Notas.findByNota3", query = "SELECT n FROM Notas n WHERE n.Nota3 = :Nota3")
    , @NamedQuery(name = "Notas.findByNota4", query = "SELECT n FROM Notas n WHERE n.Nota4 = :Nota4")
    , @NamedQuery(name = "Notas.findByPromedio", query = "SELECT n FROM Notas n WHERE n.Promedio = :Promedio")
    , @NamedQuery(name = "Notas.findByIdPeriodo", query = "SELECT n FROM Notas n WHERE n.idPeriodo = :idPeriodo")})
public class Notas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNotas")
    private Integer idNotas;
    
    @Basic(optional = false)
    @Column(name = "Nota1")
    private Double Nota1;
    
    @Basic(optional = false)
    @Column(name = "Nota2")
    private Double Nota2;
    
    @Basic(optional = false)
    @Column(name = "Nota3")
    private Double Nota3;
    
    @Basic(optional = false)
    @Column(name = "Nota4")
    private Double Nota4;
    
    @Basic(optional = false)
    @Column(name = "Promedio")
    private Double Promedio;
    
    @Basic(optional = false)
    @Column(name = "idPeriodo")
    private Integer idPeriodo;

    public Notas() {
    }

    public Notas(Integer idNotas) {
        this.idNotas = idNotas;
    }

    public Notas(Integer idNotas, Double Nota1, Double Nota2, Double Nota3, Double Nota4, Double Promedio, Integer idPeriodo) {
        this.idNotas = idNotas;
        this.Nota1 = Nota1;
        this.Nota2 = Nota2;
        this.Nota3 = Nota3;
        this.Nota4 = Nota4;
        this.Promedio = Promedio;
        this.idPeriodo = idPeriodo;
    }


    public Integer getIdNotas() {
		return idNotas;
	}

	public void setIdNotas(Integer idNotas) {
		this.idNotas = idNotas;
	}

	public Double getNota1() {
		return Nota1;
	}

	public void setNota1(Double nota1) {
		Nota1 = nota1;
	}

	public Double getNota2() {
		return Nota2;
	}

	public void setNota2(Double nota2) {
		Nota2 = nota2;
	}

	public Double getNota3() {
		return Nota3;
	}

	public void setNota3(Double nota3) {
		Nota3 = nota3;
	}

	public Double getNota4() {
		return Nota4;
	}

	public void setNota4(Double nota4) {
		Nota4 = nota4;
	}

	public Double getPromedio() {
		return Promedio;
	}

	public void setPromedio(Double promedio) {
		Promedio = promedio;
	}

	public Integer getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(Integer idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Nota1, Nota2, Nota3, Nota4, Promedio, idNotas, idPeriodo);
	}

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notas other = (Notas) obj;
		return Objects.equals(Nota1, other.Nota1) && Objects.equals(Nota2, other.Nota2)
				&& Objects.equals(Nota3, other.Nota3) && Objects.equals(Nota4, other.Nota4)
				&& Objects.equals(Promedio, other.Promedio) && Objects.equals(idNotas, other.idNotas)
				&& Objects.equals(idPeriodo, other.idPeriodo);
	}

    @Override
	public String toString() {
		return "Notas [idNotas=" + idNotas + ", Nota1=" + Nota1 + ", Nota2=" + Nota2 + ", Nota3=" + Nota3 + ", Nota4="
				+ Nota4 + ", Promedio=" + Promedio + ", idPeriodo=" + idPeriodo + "]";
	}
    
}
