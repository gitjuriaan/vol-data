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
import vol.model.Vol;


@Repository
@Transactional
public class VolDaoJpa implements VolDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly=true)
	public Vol findById(Integer id) {
		return em.find(Vol.class, id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Vol> findAll() {
		Query query = em.createQuery("select v from Vol v");
		return query.getResultList();
	}

	@Override
	public void create(Vol obj) {
		em.persist(obj);	
	}

	@Override
	public Vol update(Vol obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Vol obj) {
		em.remove(em.merge(obj)); 		
	}
	
	

}
