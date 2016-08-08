package vol.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vol.Application;
import vol.model.Aeroport;
import vol.model.Client;
import vol.model.Escale;
import vol.model.VilleAeroport;


@Repository
@Transactional
public class VilleAeroportDaoJpa implements VilleAeroportDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly=true)
	public VilleAeroport findById(Integer id) {
		return em.find(VilleAeroport.class, id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<VilleAeroport> findAll() {
		Query query = em.createQuery("select va from VilleAeroport va");
		return query.getResultList();
	}

	@Override
	public void create(VilleAeroport obj) {
		em.persist(obj);
	}

	@Override
	public VilleAeroport update(VilleAeroport obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(VilleAeroport obj) {
		em.remove(em.merge(obj));
	}

	

}
