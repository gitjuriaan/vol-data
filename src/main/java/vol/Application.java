package vol;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import vol.model.dao.AeroportDao;
import vol.model.dao.AeroportDaoJpa;
import vol.model.dao.ClientDao;
import vol.model.dao.ClientDaoJpa;
import vol.model.dao.CompagnieAerienneDao;
import vol.model.dao.CompagnieAerienneDaoJpa;
import vol.model.dao.CompagnieAerienneVolDao;
import vol.model.dao.CompagnieAerienneVolDaoJpa;
import vol.model.dao.EscaleDao;
import vol.model.dao.EscaleDaoJpa;
import vol.model.dao.LoginDao;
import vol.model.dao.LoginDaoJpa;
import vol.model.dao.PassagerDao;
import vol.model.dao.PassagerDaoJpa;
import vol.model.dao.ReservationDao;
import vol.model.dao.ReservationDaoJpa;
import vol.model.dao.VilleAeroportDao;
import vol.model.dao.VilleAeroportDaoJpa;
import vol.model.dao.VilleDao;
import vol.model.dao.VilleDaoJpa;
import vol.model.dao.VolDao;
import vol.model.dao.VolDaoJpa;

public class Application {
	private static Application instance = null;
	private final EntityManagerFactory emf;
	private final AeroportDao aeroportDao;
	private final ClientDao clientDao;
	private final CompagnieAerienneDao compagnieAerienneDao;
	private final CompagnieAerienneVolDao compagnieAerienneVolDao;
	private final EscaleDao escaleDao;
	private final LoginDao loginDao;
	private final PassagerDao passagerDao;
	private final ReservationDao reservationDao;
	private final VilleDao villeDao;
	private final VilleAeroportDao villeAeroportDao;
	private final VolDao volDao;
	
	private Application() {
		emf = Persistence.createEntityManagerFactory("agence_bestplace");
		aeroportDao = new AeroportDaoJpa();
		clientDao = new ClientDaoJpa();
		compagnieAerienneDao = new CompagnieAerienneDaoJpa();
		compagnieAerienneVolDao = new CompagnieAerienneVolDaoJpa();
		escaleDao = new EscaleDaoJpa();
		loginDao = new LoginDaoJpa();
		passagerDao = new PassagerDaoJpa();
		reservationDao = new ReservationDaoJpa();
		villeDao = new VilleDaoJpa();
		villeAeroportDao = new VilleAeroportDaoJpa();
		volDao = new VolDaoJpa();
	}
	
	public static Application getInstance() {
		if (instance == null) {
			instance = new Application();
		}
		
		return instance;
	}

	public static void close() {
		getInstance().emf.close();
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public AeroportDao getAeroportDao() {
		return aeroportDao;
	}

	public ClientDao getClientDao() {
		return clientDao;
	}

	public CompagnieAerienneDao getCompagnieAerienneDao() {
		return compagnieAerienneDao;
	}

	public CompagnieAerienneVolDao getCompagnieAerienneVolDao() {
		return compagnieAerienneVolDao;
	}

	public EscaleDao getEscaleDao() {
		return escaleDao;
	}

	public LoginDao getLoginDao() {
		return loginDao;
	}

	public PassagerDao getPassagerDao() {
		return passagerDao;
	}

	public ReservationDao getReservationDao() {
		return reservationDao;
	}

	public VilleDao getVilleDao() {
		return villeDao;
	}

	public VilleAeroportDao getVilleAeroportDao() {
		return villeAeroportDao;
	}

	public VolDao getVolDao() {
		return volDao;
	}
	
	

}
