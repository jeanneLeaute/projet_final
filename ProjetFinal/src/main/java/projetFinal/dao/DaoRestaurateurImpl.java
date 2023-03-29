package projetFinal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import projetFinal.entities.Restaurateur;

public class DaoRestaurateurImpl implements DaoRestaurateur {

	@Override
	public Restaurateur save(Restaurateur obj) {
		// TODO Auto-generated method stub
		EntityManager em = Contexte.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Restaurateur obj) {
		// TODO Auto-generated method stub
		EntityManager em = Contexte.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
		
	}

	@Override
	public void deleteByKey(String key) {
		// TODO Auto-generated method stub
		EntityManager em = Contexte.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Restaurateur.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Restaurateur findByKey(String key) {
		// TODO Auto-generated method stub
		Restaurateur restaurateur = null;
		EntityManager em = Contexte.getInstance().getEntityManagerFactory().createEntityManager();
		restaurateur = em.find(Restaurateur.class, key);
		em.close();
		return restaurateur;
	}

	@Override
	public List<Restaurateur> findAll() {
		// TODO Auto-generated method stub
		EntityManager em = Contexte.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Restaurateur> query = em.createQuery("from Restaurateur r", Restaurateur.class);
		List<Restaurateur> restaurateurs = query.getResultList();
		em.close();
		return restaurateurs;
	}

}
