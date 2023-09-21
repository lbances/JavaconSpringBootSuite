package Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="trabajdor")
public class CTrabajador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codtra;
	
	private String apetra;
	private String nomtra;
	private String dirtra;
	private String doctra;
	private String esttra;
	private String cortra;
	private String teltra;
	public CTrabajador(long codtra, String apetra, String nomtra, String dirtra, String doctra, String esttra,
			String cortra, String teltra) {
		super();
		this.codtra = codtra;
		this.apetra = apetra;
		this.nomtra = nomtra;
		this.dirtra = dirtra;
		this.doctra = doctra;
		this.esttra = esttra;
		this.cortra = cortra;
		this.teltra = teltra;
	}
	public CTrabajador() {
	
	}
	public long getCodtra() {
		return codtra;
	}
	public void setCodtra(long codtra) {
		this.codtra = codtra;
	}
	public String getApetra() {
		return apetra;
	}
	public void setApetra(String apetra) {
		this.apetra = apetra;
	}
	public String getNomtra() {
		return nomtra;
	}
	public void setNomtra(String nomtra) {
		this.nomtra = nomtra;
	}
	public String getDirtra() {
		return dirtra;
	}
	public void setDirtra(String dirtra) {
		this.dirtra = dirtra;
	}
	public String getDoctra() {
		return doctra;
	}
	public void setDoctra(String doctra) {
		this.doctra = doctra;
	}
	public String getEsttra() {
		return esttra;
	}
	public void setEsttra(String esttra) {
		this.esttra = esttra;
	}
	public String getCortra() {
		return cortra;
	}
	public void setCortra(String cortra) {
		this.cortra = cortra;
	}
	public String getTeltra() {
		return teltra;
	}
	public void setTeltra(String teltra) {
		this.teltra = teltra;
	}
	
	
	
}