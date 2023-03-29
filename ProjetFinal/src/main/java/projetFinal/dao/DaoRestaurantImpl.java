package projetFinal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import projetFinal.entities.Categorie;
import projetFinal.entities.Restaurant;

public class DaoRestaurantImpl implements DaoRestaurant {

	@Override
	public Restaurant save(Restaurant obj) {
		EntityManager em = Contexte.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Restaurant obj) {
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
		em.remove(em.find(Restaurant.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Restaurant findByKey(String key) {
		Restaurant restaurant = null;
		EntityManager em = Contexte.getInstance().getEntityManagerFactory().createEntityManager();
		restaurant  = em.find(Restaurant .class, key);
		em.close();
		return restaurant ;
	}

	@Override
	public List<Restaurant> findAll() {
		EntityManager em = Contexte.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Restaurant> query = em.createQuery("from Restaurant r", Restaurant.class);
		List<Restaurant> restaurants = query.getResultList();
		em.close();
		return restaurants;
	}

	@Override
	public List<Restaurant> findByVille(String ville) {
		EntityManager em = Contexte.getInstance().getEntityManagerFactory().createEntityManager();
		//TypedQuery<Restaurant> query = em.createQuery("from Restaurant r where r.adresse.ville like :ville", Restaurant.class);
		TypedQuery<Restaurant> query = em.createQuery("from Restaurant r left join fetch r.adresse a where a.ville like :ville", Restaurant.class);
		query.setParameter("ville", ville);
		List<Restaurant> restaurants = query.getResultList();
		em.close();
		return restaurants;
	}
	
	@Override
	public List<Restaurant> findByCategorie(Categorie categorie) {
		EntityManager em = Contexte.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Restaurant> query = em.createQuery("from Restaurant r where r.categorie like :categorie", Restaurant.class);
		query.setParameter("categorie", categorie);
		List<Restaurant> restaurants = query.getResultList();
		em.close();
		return restaurants;
	}
	
	@Override
	public List<Restaurant> findByCategorieVille(Categorie categorie, String ville) {
		EntityManager em = Contexte.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Restaurant> query = em.createQuery("from Restaurant r where r.categorie like :categorie "
				                                      + "and r.adresse.ville like :ville", Restaurant.class);
		query.setParameter("categorie", categorie);
		query.setParameter("ville", ville);
		List<Restaurant> restaurants = query.getResultList();
		em.close();
		return restaurants;
	}

}
