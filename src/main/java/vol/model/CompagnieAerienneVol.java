package vol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class CompagnieAerienneVol {

	private CompagnieAerienne compagnieAerienne;
	private Vol vol;
	private String numero;
	private boolean ouvert;
	private int version;
	
	public CompagnieAerienneVol(){
		
	}
	
	public CompagnieAerienneVol(String Numero){
		this();
		this.numero = Numero;
	}
	
	
	
	public CompagnieAerienneVol(String numero, boolean ouvert) {
		this.numero = numero;
		this.ouvert = ouvert;
	}

	@Id
	@Column(length = 50)
	public String getNumero() {
		return numero;
	}

	public boolean getOuvert() {
		return ouvert;
	}

	@ManyToOne
	@JoinColumn(name="Vol_Id")
	public Vol getVol() {
		return vol;
	}

	public boolean isOuvert() {
		return ouvert;
	}

	@ManyToOne
	@JoinColumn(name="CompagnieAerienne_Id")
	public CompagnieAerienne getCompagnieAerienne() {
		return compagnieAerienne;
	}
	
	public void setCompagnieAerienne(CompagnieAerienne compagnieAerienne) {
		this.compagnieAerienne = compagnieAerienne;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setOuvert(boolean ouvert) {
		this.ouvert = ouvert;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}
	
	@Version
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "CompagnieAerienneVol [ compagnieAerienne="
				+ compagnieAerienne + ", vol=" + vol + ", numero=" + numero + ", ouvert=" + ouvert + "]";
	}

}
