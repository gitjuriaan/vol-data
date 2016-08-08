package vol.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vol.model.Escale;


@Repository
@Transactional
public class EscaleDaoJpa implements EscaleDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly=true)
	public Escale findById(Long id) {
		return em.find(Escale.class, id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Escale> findAll() {
		Query query = em.createQuery("select e from Escale e");
		return query.getResultList();
	}

	@Override
	public void create(Escale obj) {
		em.persist(obj);		
	}

	@Override
	public Escale update(Escale obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Escale obj) {
		em.remove(em.merge(obj));		
	}
	

}
