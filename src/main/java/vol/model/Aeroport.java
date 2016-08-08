package vol.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Aeroport {

	/**
	 * id de l'aéroport
	 */
	
	private int idAer;
	/**
	 * Nom de l'aéroport
	 */
	private String nom;
	
	private List<VilleAeroport> listVilleAeroport;
	private List<Escale> escales;
	private int version;

	
	/**
	 * Constructeur de aeroport
	 */
	public Aeroport(){
		
	}
	
	public Aeroport(int idAer){
		this.idAer = idAer;
	}

	public Aeroport(int idAer, String nom) {
		this.nom = nom;
		this.idAer = idAer;
	}

	/**
	 * Ajout d'une ville existante à la liste des villes desservies par
	 * l'aéroport
	 * 
	 * @param ville
	 *            Ville à ajouter
	 */
//	public void ajouterVille(Ville ville) {
//		this.villes.add(ville); // ajout d'une ville déjà existante
//	}

	@Id
	public int getIdAer() {
		return idAer;
	}

	@Column(name = "nom_Aeroport", length = 50)
	public String getNom() {
		return nom;
	}

	
	@OneToMany(mappedBy = "aeroport")
	public List<VilleAeroport> getListVilleAeroport() {
		return listVilleAeroport;
	}

	public void setListVilleAeroport(List<VilleAeroport> listVilleAeroport) {
		this.listVilleAeroport = listVilleAeroport;
	}

	public void setIdAer(int idAer) {
		this.idAer = idAer;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Version
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}

	@OneToMany(mappedBy = "aeroport")
	public List<Escale> getEscales() {
		return escales;
	}

	public void setEscales(List<Escale> escales) {
		this.escales = escales;
	}

	

}
