package projetFinal.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Contexte {
	
	private static Contexte singleton;
	private EntityManagerFactory emf;
	
	private static DaoClient daoClient = new DaoClientImpl();
	
	public static DaoClient getDaoClient() {
		return daoClient;
	}
	
private static DaoRestaurateur daoRestaurateur = new DaoRestaurateurImpl();
	
	public static DaoRestaurateur getDaoRestaurateur() {
		return daoRestaurateur;
	}
	
private static DaoReservation daoReservation = new DaoReservationImpl();
	
	public static DaoReservation getDaoReservation() {
		return daoReservation;
	}
	
private static DaoRestaurant daoRestaurant = new DaoRestaurantImpl();
	
	public static DaoRestaurant getDaoRestaurant() {
		return daoRestaurant;
	}
	
private static DaoCommentaire daoCommentaire = new DaoCommentaireImpl();
	
	public static DaoCommentaire getDaoCommentaire() {
		return daoCommentaire;
	}
	
private static DaoItemMenu daoItemMenu = new DaoItemMenuImpl();
	
	public static DaoItemMenu getDaoItemMenu() {
		return daoItemMenu;
	}
	
	private Contexte() {
		emf = Persistence.createEntityManagerFactory("questjpa");
	}
	
	public static Contexte getInstance() {
		if (singleton == null) {
			singleton = new Contexte();
		}
		return singleton;
	}
	
	public EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}
	
	public static void destroy() {
		if (singleton != null) {
			singleton.getEntityManagerFactory().close();
			singleton = null;
		}
	}

}
