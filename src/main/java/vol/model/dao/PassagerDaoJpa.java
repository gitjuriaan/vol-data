package vol.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vol.Application;
import vol.model.Passager;

@Repository
@Transactional
public class PassagerDaoJpa implements PassagerDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional(readOnly=true)
	public Passager findById(Integer id) {
		return em.find(Passager.class, id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Passager> findAll() {
			// requête JPQL (on requête les objets, pas les tables)
			Query query = em.createQuery("select p from Passager p");  
		return query.getResultList();
	}

	@Override
	public void create(Passager obj) {
			em.persist(obj);
	}

	@Override
	public Passager update(Passager obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Passager obj) {
			em.remove(em.merge(obj));
	}

}
