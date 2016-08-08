/**
 * 
 */
package vol.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author ajc
 *
 */

@Embeddable
public class Adresse {

	private String rue;
	private String codePostal;
	private String ville;
	private String pays;

	public Adresse() {
		
	}
	
	public Adresse(String rue, String codePostal, String ville, String pays) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
	}


	@Column(name = "rue", length = 300)
	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	@Column(name = "CP", length = 10)
	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	@Column(name = "Ville", length = 200)
	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Column(name = "pays", length = 100)
	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	@Override
	public String toString() {
		return "Adresse [adresse=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + ", pays=" + pays
				+ "]";
	}

}
