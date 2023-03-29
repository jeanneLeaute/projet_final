package projetFinal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import projetFinal.entities.ItemMenu;

public class DaoItemMenuImpl implements DaoItemMenu{

	@Override
	public ItemMenu save(ItemMenu obj) {
		EntityManager em = Contexte.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(ItemMenu obj) {
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
		em.remove(em.find(ItemMenu.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public ItemMenu findByKey(Long key) {
		ItemMenu itemMenu = null;
		EntityManager em = Contexte.getInstance().getEntityManagerFactory().createEntityManager();
		itemMenu  = em.find(ItemMenu.class, key);
		em.close();
		return itemMenu;
	}

	@Override
	public List<ItemMenu> findAll() {
		EntityManager em = Contexte.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<ItemMenu> query = em.createQuery("from ItemMenu i", ItemMenu.class);
		List<ItemMenu> itemsMenu = query.getResultList();
		em.close();
		return itemsMenu;
	}

}
