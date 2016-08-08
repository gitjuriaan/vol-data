import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import vol.Application;
import vol.model.Adresse;
import vol.model.Aeroport;
import vol.model.Client;
import vol.model.ClientPhysique;
import vol.model.CompagnieAerienne;
import vol.model.CompagnieAerienneVol;
import vol.model.Escale;
import vol.model.EtatReservation;
import vol.model.Login;
import vol.model.Passager;
import vol.model.Reservation;
import vol.model.Ville;
import vol.model.VilleAeroport;
import vol.model.Vol;

public class MainTestWithDao {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat shf = new SimpleDateFormat("hh:mm");
		
		//----------------LOG---------------
		
		//Création d'un login
		Login log1 = new Login();
		
		//Initialisation des attributs de log 1
		log1.setLogin("BestPlace");
		log1.setMotDePasse("ThePlaceToBe");
		
		//Création de log1 dans la BDD
		Application.getInstance().getLoginDao().create(log1);
		
		log1.setAdmin(true);
		
		//MAJ de log1
		Application.getInstance().getLoginDao().update(log1);
		
		
		Login log2 = new Login();
		
		log2.setLogin("Truc");
		log2.setMotDePasse("MachinChose");
		
		Application.getInstance().getLoginDao().create(log2);
		
		System.out.println("Login de log2 : " +Application.getInstance().getLoginDao().findById(log2.getIdLog()).getLogin());
		
		Application.getInstance().getLoginDao().delete(log2);
		
		List<Login> logins = new ArrayList<Login>();
		
		logins = Application.getInstance().getLoginDao().findAll();
		
		System.out.println("Nombre de logins : "+logins.size());
		
		Login logBoby = new Login();
		logBoby.setMotDePasse("mdp_de_gueudin");
		logBoby.setLogin("Je_me_log");
		
		Application.getInstance().getLoginDao().create(logBoby);
		
		//--------------------AEROPORT-------------------
		
		Aeroport aero1 = new Aeroport(201, "BPAirport");
		
		Application.getInstance().getAeroportDao().create(aero1);
		
		Aeroport aero2 = new Aeroport(101, "CDG");
		
		Application.getInstance().getAeroportDao().create(aero2);
		
		Aeroport aero3 = new Aeroport(301, "ORY");
		
		Application.getInstance().getAeroportDao().create(aero3);
		
		aero2.setNom("Charles De Gaulles");
		
		aero2 = Application.getInstance().getAeroportDao().update(aero2);
		
		Application.getInstance().getAeroportDao().delete(aero3);
		
		//--------------------VOL--------------------
		
		Vol vol1 = new Vol(1546);
		
		vol1.setAeroportDepart(aero1);
		vol1.setAeroportArrivee(aero2);
		vol1.setDateArrivee(sdf.parse("06/08/2016"));
		vol1.setDateDepart(sdf.parse("04/08/2016"));
		vol1.setHeureDepart(shf.parse("04:00"));
		vol1.setHeureArrivee(shf.parse("18:30"));
		
		Application.getInstance().getVolDao().create(vol1);
		
		Vol vol2 = new Vol(52);
		
		vol2.setAeroportDepart(aero1);
		vol2.setAeroportArrivee(aero2);
		vol2.setDateArrivee(sdf.parse("12/03/2017"));
		vol2.setDateDepart(sdf.parse("10/03/2017"));
		vol2.setHeureDepart(shf.parse("04:00"));
		vol2.setHeureArrivee(shf.parse("18:30"));
		
		Application.getInstance().getVolDao().create(vol2);
		
		vol2.setHeureDepart(shf.parse("06:00"));
		
		Application.getInstance().getVolDao().update(vol2);
		
		Vol vol3 = new Vol(4948);
		
		Application.getInstance().getVolDao().create(vol3);
		
		Application.getInstance().getVolDao().delete(vol3);
		
		
		//-------------------ESCALE--------------------------
		
		Escale esc1 = new Escale();
		
		esc1.setAeroport(aero2);
		esc1.setDateArrivee(sdf.parse("05/08/2016"));
		esc1.setDateDepart(sdf.parse("05/08/2016"));
		esc1.setVol(vol1);
		
		Application.getInstance().getEscaleDao().create(esc1);
		
		
		//--------------------CLIENT--------------------------
		
		Client Boby = new ClientPhysique("Boby");
		Boby.setNom("Bybul");
		Boby.setEmail("leBGdu33@hotmail.fr");
		Boby.setNumeroTel("0606060606");
		Boby.setNumeroFax("0909090909");
		Boby.setAdresse(new Adresse("12 rue La Vache sur le toît", "12345", "C'est Vachement Sympa", "France"));
		Boby.setLog(logBoby);
		
		Application.getInstance().getClientDao().create(Boby);
		
		Boby.setNumeroTel("0707070707");
		
		Application.getInstance().getClientDao().update(Boby);
		
		//-------------------------PASSAGER--------------------
		
		Passager Ronald = new Passager();
		Ronald.setAdresse(new Adresse("33 allée Du Haaaaaaaan", "99999", "LeviosaaaCity", "Angleterre"));
		Ronald.setNom("Wisley");
		Ronald.setPrenom("Ronald");	
		
		Application.getInstance().getPassagerDao().create(Ronald);
		
		Passager floflo = new Passager();
		floflo.setPrenom("Florent");
		floflo.setNom("Darto");
		floflo.setAdresse(new Adresse("3 rue de l'église", "33700", "Bordeaux", "France"));
		
		Application.getInstance().getPassagerDao().create(floflo);
		
		Passager rob = new Passager();
		rob.setPrenom("Rob");
		rob.setNom("Robert");
		rob.setAdresse(new Adresse("5 rue de la poste", "75000", "Paris", "France"));
		
		Application.getInstance().getPassagerDao().create(rob);
		
		//Update :
		rob.setPrenom("Paul");
		Application.getInstance().getPassagerDao().update(rob);
		
		
		//Delete :
		Application.getInstance().getPassagerDao().delete(rob);
		
		//-----------------------VILLE---------------------------
		
		Ville Zouglouland = new Ville ("Zouglouland");
		
		Application.getInstance().getVilleDao().create(Zouglouland);
		
		Zouglouland.setNom("Zougglouland");
		
		Application.getInstance().getVilleDao().update(Zouglouland);
		
		//---------------------VILLE AEROPORT------------------------
		
		VilleAeroport VA = new VilleAeroport(Zouglouland, aero1);
		
		Application.getInstance().getVilleAeroportDao().create(VA);
		
		//----------------------------RESERVATION----------------------
		
		Reservation vacaaances = new Reservation();
		vacaaances.setDate(sdf.parse("04/08/2016"));
		vacaaances.setClient(Boby);
		vacaaances.setPassager(Ronald);
		
		Application.getInstance().getReservationDao().create(vacaaances);
		
		vacaaances.setEtat(EtatReservation.ferme);
		
		Application.getInstance().getReservationDao().update(vacaaances);
		
		//-------------------COMPAGNIE AERIENNE------------------
		
		CompagnieAerienne comp1 = new CompagnieAerienne();
		comp1.setNom("Air France");
		
		
		CompagnieAerienne comp2 = new CompagnieAerienne();
		comp2.setNom("Easy Jet");
		
		Application.getInstance().getCompagnieAerienneDao().create(comp1);
		
		Application.getInstance().getCompagnieAerienneDao().create(comp2);
		
		//Update :
		comp2.setNom("KLM");
		Application.getInstance().getCompagnieAerienneDao().update(comp2);
		
		//Delete :
		//Application.getInstance().getCompagnieAerienneDao().delete(comp2);
		
		//----------------------COMPAGNIE AERIENNE VOL---------------------
		
		CompagnieAerienneVol cav1 = new CompagnieAerienneVol("2456225");
		cav1.setOuvert(true);
		
		Application.getInstance().getCompagnieAerienneVolDao().create(cav1);
		cav1.setCompagnieAerienne(comp1);
		
		cav1 = Application.getInstance().getCompagnieAerienneVolDao().update(cav1);
		
		cav1.setVol(vol1);
		
		Application.getInstance().getCompagnieAerienneVolDao().update(cav1);
		
	}

}
