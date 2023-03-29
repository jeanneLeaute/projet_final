package projetFinal.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import projetFinal.entities.Client;
import projetFinal.entities.Commentaire;
import projetFinal.entities.Restaurant;





public class DaoCommentaireImpl implements DaoCommentaire {

	@Override
	public Commentaire save(Commentaire obj) {
		EntityManager em = Contexte.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Commentaire obj) {
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
		em.remove(em.find(Commentaire.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Commentaire findByKey(String key) {
		EntityManager em = Contexte.getInstance().getEntityManagerFactory().createEntityManager();
		Commentaire commentaire = em.find(Commentaire.class, key);
		em.close();
		return commentaire;
		
	}

	@Override
	public List<Commentaire> findAll() {
		EntityManager em = Contexte.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Commentaire> query = em.createQuery("from commentaire c", Commentaire.class);
		List<Commentaire> commentaires = query.getResultList();
		em.close();
		return commentaires;
	}

	
	public List<Commentaire> findByClient(Client client) {
		EntityManager em = Contexte.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Commentaire> query = em.createQuery("from Commentaire c where c.client=:client", Commentaire.class);
		query.setParameter("client", client);
		List<Commentaire> commentaires = query.getResultList();
		em.close();
		return commentaires;
	}
	
	public List<Commentaire> findByRestaurant(Restaurant restaurant) {
		EntityManager em = Contexte.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Commentaire> query = em.createQuery("from Commentaire c where c.restaurant=:restaurant", Commentaire.class);
		query.setParameter("restaurant", restaurant);
		List<Commentaire> commentaires = query.getResultList();
		em.close();
		return commentaires;
		
	}

}
