package vol.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class CompagnieAerienne {
	
	/**
	 * Id de la compagnie aérienne
	 */
	private int id;
	
	/**
	 * Nom de la compagnie aérienne
	 */
	private String nom;

	private List<CompagnieAerienneVol> compagnieaeriennes = new ArrayList<CompagnieAerienneVol>();
	
	private int version;
	
	
	public CompagnieAerienne() {
		
	}
	
	
 	public CompagnieAerienne(int id, String nom) {
 		this();
		this.id = id;
		this.nom = nom;
	}

 	
 	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(length = 50)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	@OneToMany(mappedBy="compagnieAerienne")
	public List<CompagnieAerienneVol> getCompagnieaeriennes() {
		return compagnieaeriennes;
	}


	public void setCompagnieaeriennes(List<CompagnieAerienneVol> compagnieaeriennes) {
		this.compagnieaeriennes = compagnieaeriennes;
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
		return "CompagnieAerienne [id=" + id + ", nom=" + nom + "]";
	}


	

}
