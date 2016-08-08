package vol.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Passager {

	/**
	 * Id du passager
	 */
	private int idPas;
	/**
	 * Nom du passager
	 */
	private String nom;
	/**
	 * Prenom du passager
	 */
	private String prenom;

	private Adresse adresse;

	private List<Reservation> reservations = new ArrayList <Reservation>();
	
	private int version;

	public Passager() {
		super();
	}


	public Passager(int idPas) {

		this.idPas = idPas;

	}
	
	
	

	@Id
	@GeneratedValue
	public int getIdPas() {
		return idPas;
	}

	public void setIdPas(int idPas) {
		this.idPas = idPas;
	}

	
	@Column(length = 50)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(length = 50)
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Embedded
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	
	
	@OneToMany (mappedBy = "passager")
	public List<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
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
		return "Passager [idPas=" + idPas + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + "]";
	}

}
