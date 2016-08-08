package vol.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vol.model.Login;

@Repository
@Transactional
public class LoginDaoJpa implements LoginDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly=true)
	public Login findById(Integer id) {
		return em.find(Login.class, id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Login> findAll() {
			// requête JPQL (on requête les objets, pas les tables)
			Query query = em.createQuery("select c from Login c");
		return query.getResultList();
	}

	@Override
	public void create(Login obj) {
			em.persist(obj);
	}

	@Override
	public Login update(Login obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Login obj) {
			em.remove(em.merge(obj));
	}

}
