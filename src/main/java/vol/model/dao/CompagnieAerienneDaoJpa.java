package vol.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vol.model.CompagnieAerienne;

@Repository
@Transactional
public class CompagnieAerienneDaoJpa implements CompagnieAerienneDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly=true)
	public CompagnieAerienne findById(Integer id) {
		return em.find(CompagnieAerienne.class, id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<CompagnieAerienne> findAll() {
		Query query = em.createQuery("select ca from CompagnieAerienne ca");
		return query.getResultList();
	}

	@Override
	public void create(CompagnieAerienne obj) {
		em.persist(obj);
	}

	@Override
	public CompagnieAerienne update(CompagnieAerienne obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(CompagnieAerienne obj) {
		em.remove(em.merge(obj));
	}

}
