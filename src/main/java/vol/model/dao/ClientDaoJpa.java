package vol.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vol.model.Client;

@Repository
@Transactional
public class ClientDaoJpa implements ClientDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly=true)
	public Client findById(Integer id) {
		return em.find(Client.class, id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Client> findAll() {
			// requête JPQL (on requête les objets, pas les tables)
			Query query = em.createQuery("select cl from Client cl");
		return query.getResultList();
	}

	@Override
	public void create(Client obj) {
			em.persist(obj);
	}

	@Override
	public Client update(Client obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Client obj) {
			em.remove(em.merge(obj));
		}
	}
