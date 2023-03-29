package projetFinal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import projetFinal.entities.Client;
import projetFinal.entities.Reservation;
import projetFinal.entities.Restaurant;

public class DaoReservationImpl implements DaoReservation{

	@Override
	public Reservation save(Reservation obj) {
		EntityManager em = Contexte.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Reservation obj) {
		EntityManager em = Contexte.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
	}

	@Override
	public void deleteByKey(Long key) {
		EntityManager em = Contexte.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Reservation.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Reservation findByKey(Long key) {
		EntityManager em = Contexte.getInstance().getEntityManagerFactory().createEntityManager();
		Reservation reservation = em.find(Reservation.class, key);
		em.close();
		return reservation;
	}

	@Override
	public List<Reservation> findAll() {
		EntityManager em = Contexte.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Reservation> query = em.createQuery("from Reservation p", Reservation.class);
		List<Reservation> reservations = query.getResultList();
		em.close();
		return reservations;
	}
	
	public List<Reservation> findByClient(Client client) {
		EntityManager em = Contexte.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Reservation> query = em.createQuery("from Reservation r where r.client=:client", Reservation.class);
		query.setParameter("client", client);
		List<Reservation> reservations = query.getResultList();
		em.close();
		return reservations;
	}
	
	public List<Reservation> findByRestaurant(Restaurant restaurant) {
		EntityManager em = Contexte.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Reservation> query = em.createQuery("from Reservation r where r.restaurant=:restaurant", Reservation.class);
		query.setParameter("restaurant", restaurant);
		List<Reservation> reservations = query.getResultList();
		em.close();
		return reservations;
	}
	
}
