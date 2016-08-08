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
public class Ville {
	
	/**
	 * Id de la ville
	 */
	private int idVil;
	
	/**
	 * Nom de la ville
	 */
	private String nom;
	
	private List<VilleAeroport> listVilleAeroport;
	
	private int version;
	
	public Ville(){
		this.listVilleAeroport = new ArrayList<>();
				
	}

	public Ville(String nom) {
		this.nom = nom;
		}

	@Id
	@GeneratedValue
	public int getIdVil() {
		return idVil;
	}

	public void setIdVil(int idVil) {
		this.idVil = idVil;
	}

	@Column(name = "Nom_ville", length = 50)
	public String getNom() {
		return nom;
	}
	
	@OneToMany(mappedBy="ville")
	public List<VilleAeroport> getListVilleAeroport() {
		return listVilleAeroport;
	}

	public void setListVilleAeroport(List<VilleAeroport> listVilleAeroport) {
		this.listVilleAeroport = listVilleAeroport;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String toString() {
		String reponse="La Ville : "+this.nom;
				
		return reponse;
}
	
	@Version
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}

}
