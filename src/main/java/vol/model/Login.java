/**
 * 
 */
package vol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * @author ajc
 *
 */

@Entity
@Table(name = "Login")
public class Login {

	private int idLog;
	private String Login;
	private String motDePasse;
	private boolean admin;
	private Client client;
	private int version;
	
	public Login() {
		
	}
	
	@Id
	@GeneratedValue
	@Column(name = "Id")
	public int getIdLog() {
		return idLog;
	}

	public void setIdLog(int idLog) {
		this.idLog = idLog;
	}
	
	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Column(name = "Login", length = 50)
	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	@Column(name = "Mot_de_passe", length = 50)
	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	@Column(name = "Admin")
	public boolean getAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	@OneToOne(mappedBy = "log")
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Login [idLog=" + idLog + ", Login=" + Login + ", motDePasse=" + motDePasse + ", admin=" + admin + "]";
	}
	
	

}
