/**
 * 
 */
package vol.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

/**
 * @author ajc
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name= "Type_de_client", discriminatorType=DiscriminatorType.STRING)
public abstract class Client {

	/**
	 * 
	 */
	private Integer idCli;
	private String nom;
	private String numeroTel;
	private String numeroFax;
	private String email;

	private Titre titre;
	
	private int version;


	private List<Reservation> ListReservations;
	private Adresse adresse;
	private Login Log;

	public Client() {
		this.ListReservations = new ArrayList<>();
	}

	@Embedded
	public Adresse getAdresse() {
		return adresse;
	}

	public String getEmail() {
		return email;
	}
	
	@Id
	@GeneratedValue
	public Integer getIdCli() {
		return idCli;
	}

	public Titre getTitre() {
		return titre;
	}

	public void setTitre(Titre titre) {
		this.titre = titre;
	}

	@OneToMany(mappedBy = "client")
	public List<Reservation> getListReservations() {
		return ListReservations;
	}
	
	@OneToOne
	@JoinColumn(name="Login")
	public Login getLog() {
		return Log;
	}

	public String getNom() {
		return nom;
	}

	public String getNumeroFax() {
		return numeroFax;
	}

	public String getNumeroTel() {
		return numeroTel;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setIdCli(Integer idCli) {
		this.idCli = idCli;
	}

	public void setListReservations(List<Reservation> listReservations) {
		ListReservations = listReservations;
	}

	public void setLog(Login log) {
		Log = log;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setNumeroFax(String numeroFax) {
		this.numeroFax = numeroFax;
	}

	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}

	@Version
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}

}
