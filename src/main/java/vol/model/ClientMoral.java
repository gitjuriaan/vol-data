package vol.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity @DiscriminatorValue("ClientMoral")
public class ClientMoral extends Client{
	
	private int siret;

	public ClientMoral() {
		super();
	}

	public ClientMoral(int siret) {
		super();
		this.siret = siret;
	}

	public int getSiret() {
		return siret;
	}

	public void setSiret(int siret) {
		this.siret = siret;
	}
	
	
	
	

}
