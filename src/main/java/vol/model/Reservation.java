package vol.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Reservation {

	/**
	 * Id de la réservation
	 */
	private int idRes;
	/**
	 * Date de la réservation
	 */
	private Date date;
	/**
	 * Numéro de la réservation
	 */
	private int numero;
	/**
	 * Etat de la réservation (ouvert ou fermé)
	 */
	private EtatReservation etat;
	private Vol vol;
	private Passager passager;
	private Client client;
	private int version;
	
	
	// constructeur par défaut !
	public Reservation() {
		super();
	}

	public Reservation(int idRes) {
		this.idRes = idRes;
	}

	@ManyToOne
	@JoinColumn(name="client_id", referencedColumnName="idCli")
	public Client getClient() {
		return client;
	}

	public Date getDate() {
		return date;
	}

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	public EtatReservation getEtat() {
		return etat;
	}

	@Id
	@GeneratedValue
	public int getIdRes() {
		return idRes;
	}


	public int getNumero() {
		return numero;
	}

	@ManyToOne
	@JoinColumn(name="passager_id", referencedColumnName="idPas")
	public Passager getPassager() {
		return passager;
	}

	@ManyToOne
	@JoinColumn(name="vol_id")
	public Vol getVol() {
		return vol;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setEtat(EtatReservation etat) {
		this.etat = etat;
	}


	public void setIdRes(int idRes) {
		this.idRes = idRes;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setPassager(Passager passager) {
		this.passager = passager;
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
//
//	public String toString() {
//		String reponse = "La Reservation : " + this.numero + " a été effectuée par le Client : \n" + client.getNom()
//				+ " " + client.getPrenom() + "\nElle porte sur le vol de " + vol.getAeroportDepart().getNom() + " à "
//				+ vol.getAeroportArrivee().getNom() + ".\nElle concerne le passager :\n" + passager.getNom() + " "
//				+ passager.getPrenom();
//
//		return reponse;
//	}

}
