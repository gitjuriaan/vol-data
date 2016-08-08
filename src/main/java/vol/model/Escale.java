/**
 * 
 */
package vol.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * @author ajc
 *
 */
@Entity
public class Escale {

	private Long id;
	private Date dateDepart;
	private Date dateArrivee;
	private Date heureDepart;
	private Date heureArrivee;
	private Vol vol;
	private Aeroport aeroport;
	private int version;

	public Escale() {

		this.dateDepart = null;
		this.dateArrivee = null;
		this.heureDepart = null;
		this.heureArrivee = null;

	}
	
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "Date_arrivee")
	public Date getDateArrivee() {
		return dateArrivee;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Date_depart")
	public Date getDateDepart() {
		return dateDepart;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "Heure_arrivee")
	public Date getHeureArrivee() {
		return heureArrivee;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "Heure_depart")
	public Date getHeureDepart() {
		return heureDepart;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public void setHeureArrivee(Date heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

	public void setHeureDepart(Date heureDepart) {
		this.heureDepart = heureDepart;
	}
	
	@ManyToOne
	@JoinColumns(@JoinColumn (name = "idVol"))
	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}
	
	@ManyToOne
	@JoinColumns(@JoinColumn (name = "idAer"))
	public Aeroport getAeroport() {
		return aeroport;
	}

	public void setAeroport(Aeroport aeroport) {
		this.aeroport = aeroport;
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
		return "Escale [dateDepart=" + dateDepart + ", dateArrivee=" + dateArrivee + ", heureDepart=" + heureDepart
				+ ", heureArrivee=" + heureArrivee + ", vol=" + vol + ", aeoroport="
				+ aeroport + "]";
	}



}
