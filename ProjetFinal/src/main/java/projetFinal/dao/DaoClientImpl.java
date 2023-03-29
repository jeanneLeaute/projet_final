package projetFinal.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import projetFinal.entities.Client;

public class DaoClientImpl implements DaoClient {

	@Override
	public Client save(Client obj) {
		EntityManager em = Contexte.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Client obj) {
		EntityManager em = Contexte.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
	}

	@Override
	public void deleteByKey(String key) {
		EntityManager em = Contexte.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Client.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Client findByKey(String key) {
		EntityManager em = Contexte.getInstance().getEntityManagerFactory().createEntityManager();
		Client client = em.find(Client.class, key);
		em.close();
		return client;
	}

	@Override
	public List<Client> findAll() {
		EntityManager em = Contexte.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Client> query = em.createQuery("from Client p", Client.class);
		List<Client> clients = query.getResultList();
		em.close();
		return clients;
	}

}
