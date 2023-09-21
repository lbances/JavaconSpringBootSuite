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

@Entity
@Table(name="personal")
@XmlRootElement
@NamedQueries({
	@NamedQuery (name = "Personal.findAll", query = "SELECT p FROM Personal p")
	,@NamedQuery(name = "Personal.findByIdPersonal", query = "SELECT p FROM Personal p WHERE p.idPersonal = :idPersonal")
	,@NamedQuery(name = "Personal.findByNombre", query = "SELECT p FROM Personal p WHERE p.Nombre = :Nombre")
	,@NamedQuery(name = "Personal.findByApellidos", query = "SELECT p FROM Personal p WHERE p.Apellidos = :Apellidos")
	,@NamedQuery(name = "Personal.findByUsuario", query = "SELECT p FROM Personal p WHERE p.Usuario = :Usuario")
	,@NamedQuery(name = "Personal.findByClave", query = "SELECT p FROM Personal p WHERE p.Clave = :Clave")})	

public class Personal implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic (optional = false)
    @Column(name = "idPersonal")
    private Integer idPersonal;
    
    @Basic(optional = false)
    @Column(name="Nombre")
    private String Nombre;
    
    @Basic (optional = false)
    @Column(name = "Apellidos")
    private String Apellidos;
    
    @Basic (optional = false)
    @Column(name = "Usuario")
    private String Usuario;
    
    @Basic (optional = false)
    @Column(name = "Clave")
    private String Clave;
    
    public Personal() {
    	
    }
	
    public Personal (Integer idPersonal, String Nombre, String Apellidos, String Usuario, String Clave) {
    	this.idPersonal = idPersonal;
    	this.Nombre = Nombre;
    	this.Apellidos = Apellidos;
    	this.Usuario = Usuario;
    	this.Clave = Clave;
    }



	public Integer getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(Integer idPersonal) {
		this.idPersonal = idPersonal;
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

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public String getClave() {
		return Clave;
	}

	public void setClave(String clave) {
		Clave = clave;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Apellidos, Clave, Nombre, Usuario, idPersonal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personal other = (Personal) obj;
		return Objects.equals(Apellidos, other.Apellidos) && Objects.equals(Clave, other.Clave)
				&& Objects.equals(Nombre, other.Nombre) && Objects.equals(Usuario, other.Usuario)
				&& Objects.equals(idPersonal, other.idPersonal);
	}

	@Override
	public String toString() {
		return "Personal [idPersonal=" + idPersonal + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", Usuario="
				+ Usuario + ", Clave=" + Clave + "]";
	}
	
}
