package vol.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * @author ajc
 *
 */

@Entity
@Table (name = "Vol")
public class Vol {

	private int idVol;
	private Date dateDepart;
	private Date dateArrivee;
	private Date heureDepart;
	private Date heureArrivee;
	private Aeroport aeroportDepart;
	private Aeroport aeroportArrivee;
	private List<Escale> escales;
	private List<Reservation> reservations;
	private List<CompagnieAerienneVol> compagnieAerienneVols;
	private int version;

	
	public Vol(){
		this.escales = new ArrayList<Escale>();
	}
	
	public Vol(int idVol) {
		this.idVol = idVol;
		this.escales = new ArrayList<Escale>();
	}


	@Id
	public int getIdVol() {
		return idVol;
	}
	public void setIdVol(int idVol) {
		this.idVol = idVol;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "Date_depart_vol")
	public Date getDateDepart() {
		return dateDepart;
	}
	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "Date_arrivee_vol")
	public Date getDateArrivee() {
		return dateArrivee;
	}
	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}
	
	@Temporal(TemporalType.TIME)
	@Column(name = "Heure_depart_vol")
	public Date getHeureDepart() {
		return heureDepart;
	}
	public void setHeureDepart(Date heureDepart) {
		this.heureDepart = heureDepart;
	}
	
	@Temporal(TemporalType.TIME)
	@Column(name = "Heure_arrivee_vol")
	public Date getHeureArrivee() {
		return heureArrivee;
	}
	public void setHeureArrivee(Date heureArrivee) {
		this.heureArrivee = heureArrivee;
	}
	
	@ManyToOne
	@JoinColumns(@JoinColumn(name = "aeroport_depart"))
	public Aeroport getAeroportDepart() {
		return aeroportDepart;
	}
	public void setAeroportDepart(Aeroport aeroportDepart) {
		this.aeroportDepart = aeroportDepart;
	}
	
	@ManyToOne
	@JoinColumns(@JoinColumn(name = "aeroport_arrivee"))
	public Aeroport getAeroportArrivee() {
		return aeroportArrivee;
	}
	public void setAeroportArrivee(Aeroport aeroportArrivee) {
		this.aeroportArrivee = aeroportArrivee;
	}
	
	@OneToMany(mappedBy = "vol")
	public List<Escale> getEscales() {
		return escales;
	}
	public void setEscales(List<Escale> escales) {
		this.escales = escales;
	}
	
	@Version
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	@OneToMany(mappedBy = "vol")
	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@OneToMany(mappedBy = "vol")
	public List<CompagnieAerienneVol> getCompagnieAerienneVols() {
		return compagnieAerienneVols;
	}

	public void setCompagnieAerienneVols(List<CompagnieAerienneVol> compagnieAerienneVols) {
		this.compagnieAerienneVols = compagnieAerienneVols;
	}

	public String toString() {
		String reponse = "Le vol  de : " + this.aeroportDepart.getNom() + " qui part le " + this.dateDepart + " à "
				+ this.heureDepart + "\n Arrivera à " + this.aeroportArrivee.getNom() + " à " + this.heureArrivee
				+ "\nIl fera des escales à : ";
		for (int i =0; i < escales.size(); i++) {
			reponse += "\n" + this.escales.get(i).getAeroport().getNom() + " le "
					+ this.escales.get(i).getDateArrivee() + " à " + this.escales.get(i).getHeureArrivee() + "jusqu'au"
					+ this.escales.get(i).getDateDepart() + " à " + this.escales.get(i).getHeureDepart();
		}

		return reponse;
	}
}
