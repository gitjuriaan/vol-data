package vol.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity @DiscriminatorValue("ClientEI")
public class ClientEI extends Client{

	private String prenom;
	
	public ClientEI() {
		super();
	}
	
	public ClientEI(String prenom){
		super();
		this.prenom = prenom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	

}
