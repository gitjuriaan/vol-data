

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import vol.model.Aeroport;
import vol.model.Escale;
import vol.model.Ville;
import vol.model.Vol;
import vol.model.dao.AeroportDao;
import vol.model.dao.EscaleDao;
import vol.model.dao.VilleDao;
import vol.model.dao.VolDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestJunit4Spring {
	@Autowired
	private EscaleDao escaleDao;
	
	@Autowired
	private VolDao volDao;
	
	@Autowired
	private AeroportDao aeroportDao;
	
	@Autowired
	private VilleDao villeDao;
	
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat shf = new SimpleDateFormat("HH:mm");

	
	@Test
	public void testAeroport() {
		Aeroport aeroport1 = new Aeroport(1111);
		aeroport1.setNom("nomAeroport1");

		// INSERT
		aeroportDao.create(aeroport1);

		// SELECT
		aeroport1 = aeroportDao.findById(1111);

		// Assert.assertEquals(depot, depotFind);
		Assert.assertNotNull(aeroport1);
		Assert.assertEquals("nomAeroport1", aeroport1.getNom());

		aeroport1.setNom("nomTest");
		
		// UPDATE
		aeroportDao.update(aeroport1);

		// SELECT
		aeroport1 = aeroportDao.findById(1111);

		Assert.assertNotNull(aeroport1);
		Assert.assertEquals("nomTest", aeroport1.getNom());

		List<Aeroport> aeroports = aeroportDao.findAll();

		Assert.assertEquals(1, aeroports.size());

		// DELETE
		aeroportDao.delete(aeroport1);

		aeroport1 = aeroportDao.findById(1111);

		Assert.assertNull(aeroport1);

	}
	
	@Test
	public void testVol() throws ParseException {
		Vol vol = new Vol(1);
		vol.setDateArrivee(sdf.parse("08/08/2016"));
		vol.setDateDepart(sdf.parse("06/08/2016"));
		vol.setHeureArrivee(shf.parse("07:40"));
		vol.setHeureDepart(shf.parse("06:10"));

		// INSERT
		volDao.create(vol);

		// SELECT
		vol = volDao.findById(1);

		Assert.assertNotNull(vol);

		Assert.assertEquals(sdf.parse("08/08/2016"), vol.getDateArrivee());
		Assert.assertEquals(sdf.parse("06/08/2016"), vol.getDateDepart());
		Assert.assertEquals(shf.parse("07:40"), vol.getHeureArrivee());
		Assert.assertEquals(shf.parse("06:10"), vol.getHeureDepart());

		vol.setDateArrivee(sdf.parse("09/08/2016"));
		vol.setDateDepart(sdf.parse("07/08/2016"));
		vol.setHeureArrivee(shf.parse("08:40"));
		vol.setHeureDepart(shf.parse("06:30"));

		// UPDATE
		volDao.update(vol);

		// SELECT
		vol = volDao.findById(1);

		Assert.assertNotNull(vol);

		Assert.assertEquals(sdf.parse("09/08/2016"), vol.getDateArrivee());
		Assert.assertEquals(sdf.parse("07/08/2016"), vol.getDateDepart());
		Assert.assertEquals(shf.parse("08:40"), vol.getHeureArrivee());
		Assert.assertEquals(shf.parse("06:30"), vol.getHeureDepart());

		List<Vol> vols = volDao.findAll();

		Assert.assertEquals(1, vols.size());

		volDao.delete(vol);

		vol = volDao.findById(1);

		Assert.assertNull(vol);

	}
	
	@Test
	public void testEscale() throws ParseException {
		Escale escale1 = new Escale();
		escale1.setDateDepart(sdf.parse("02/08/2016"));
		escale1.setDateArrivee(sdf.parse("02/08/2016"));
		escale1.setHeureDepart(shf.parse("18:50"));
		escale1.setHeureArrivee(shf.parse("12:35"));

		// INSERT
		escaleDao.create(escale1);

		// SELECT
		escale1 = escaleDao.findById(escale1.getId());

		// Assert.assertEquals(depot, depotFind);
		Assert.assertNotNull(escale1);

		Assert.assertEquals(sdf.parse("02/08/2016"), escale1.getDateDepart());
		Assert.assertEquals(sdf.parse("02/08/2016"), escale1.getDateArrivee());
		Assert.assertEquals(shf.parse("18:50"), escale1.getHeureDepart());
		Assert.assertEquals(shf.parse("18:50"), escale1.getHeureDepart());

		escale1.setDateDepart(sdf.parse("04/08/2016"));
		escale1.setDateArrivee(sdf.parse("03/08/2016"));
		escale1.setHeureDepart(shf.parse("10:50"));
		escale1.setHeureArrivee(shf.parse("23:45"));

		// UPDATE
		escaleDao.update(escale1);

		// SELECT
		escale1 = escaleDao.findById(escale1.getId());

		Assert.assertNotNull(escale1);

		Assert.assertEquals(sdf.parse("04/08/2016"), escale1.getDateDepart());
		Assert.assertEquals(sdf.parse("03/08/2016"), escale1.getDateArrivee());
		Assert.assertEquals(shf.parse("10:50"), escale1.getHeureDepart());
		Assert.assertEquals(shf.parse("23:45"), escale1.getHeureArrivee());

		List<Escale> escales = escaleDao.findAll();

		Assert.assertEquals(1, escales.size());

		escaleDao.delete(escale1);

		escale1 = escaleDao.findById(escale1.getId());

		Assert.assertNull(escale1);

	}


	@Test
	public void testRelationEscale() throws ParseException {
		Vol vol1 = new Vol(1111);
		Vol vol2 = new Vol(2222);
		Aeroport aeroport1 = new Aeroport(99);
		Aeroport aeroport2 = new Aeroport(77);
		Escale escale1 = new Escale();
		
		escale1.setVol(vol1);
		escale1.setAeroport(aeroport1);
		
		// INSERT
		volDao.create(vol1);
		volDao.create(vol2);
		aeroportDao.create(aeroport1);
		aeroportDao.create(aeroport2);
		escaleDao.create(escale1);
		
		// SELECT
		vol1 = volDao.findById(1111);
		vol2 = volDao.findById(2222);
		aeroport1 = aeroportDao.findById(99);
		aeroport2 = aeroportDao.findById(77);
		escale1 = escaleDao.findById(escale1.getId());
		
		Assert.assertNotNull(vol1);
		Assert.assertNotNull(vol2);
		Assert.assertNotNull(aeroport1);
		Assert.assertNotNull(aeroport2);
		Assert.assertNotNull(escale1);
		
		Assert.assertEquals(1111, escale1.getVol().getIdVol());
		Assert.assertEquals(99, escale1.getAeroport().getIdAer());
		
		escale1.setVol(vol2);
		escale1.setAeroport(aeroport2);
		
		// UPDATE
		escaleDao.update(escale1);

		// SELECT
		vol1 = volDao.findById(1111);
		vol2 = volDao.findById(2222);
		aeroport1 = aeroportDao.findById(99);
		aeroport2 = aeroportDao.findById(77);
		escale1 = escaleDao.findById(escale1.getId());
		
		Assert.assertNotNull(vol1);
		Assert.assertNotNull(vol2);
		Assert.assertNotNull(aeroport1);
		Assert.assertNotNull(aeroport2);
		Assert.assertNotNull(escale1);
		
		Assert.assertEquals(2222, escale1.getVol().getIdVol());
		Assert.assertEquals(77, escale1.getAeroport().getIdAer());
		
		escaleDao.delete(escale1);
		volDao.delete(vol1);
		volDao.delete(vol2);
		aeroportDao.delete(aeroport1);
		aeroportDao.delete(aeroport2);
		

		vol1 = volDao.findById(1111);
		vol2 = volDao.findById(2222);
		aeroport1 = aeroportDao.findById(99);
		aeroport2 = aeroportDao.findById(77);
		escale1 = escaleDao.findById(escale1.getId());

		Assert.assertNull(vol1);
		Assert.assertNull(vol2);
		Assert.assertNull(aeroport1);
		Assert.assertNull(aeroport2);
		Assert.assertNull(escale1);		
	}
	
	
	@Test
	public void testVille() {
		Ville ville = new Ville();
		ville.setNom("Lyon");

		// INSERT
		villeDao.create(ville);

		// SELECT
		ville = villeDao.findById(ville.getIdVil());

		Assert.assertNotNull(ville);

		Assert.assertEquals("Lyon", ville.getNom());

		ville.setNom("London");

		// UPDATE
		villeDao.update(ville);

		// SELECT
		ville = villeDao.findById(ville.getIdVil());

		Assert.assertNotNull(ville);

		Assert.assertEquals("London", ville.getNom());

		List<Ville> villes = villeDao.findAll();

		Assert.assertEquals(1, villes.size());

		villeDao.delete(ville);

		ville = villeDao.findById(ville.getIdVil());

		Assert.assertNull(ville);

	}
	
	
}
