package vol.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class VilleAeroport {

	private int id;
	private Ville ville;
	private Aeroport aeroport;
	private int version;

	public VilleAeroport(){
		
	}
	
	
	
	public VilleAeroport(Ville ville, Aeroport aeroport) {
		this();
		this.ville = ville;
		this.aeroport = aeroport;
	}



	@ManyToOne
	@JoinColumn(name = "Aeroport")
	public Aeroport getAeroport() {
		return aeroport;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}


	@ManyToOne
	@JoinColumn(name = "Ville")
	public Ville getVille() {
		return ville;
	}

	@ManyToOne
	@JoinColumn(name = "Aeroport")
	public void setAeroport(Aeroport aeroport) {
		this.aeroport = aeroport;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}
	
	public String toString() {
		String reponse="La Ville : "+ville.getNom()+" est desservie par l'aéroport : "+aeroport.getNom()+".";
				
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
