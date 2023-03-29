package projetFinal.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Contexte {
	
	private static Contexte singleton;
	private EntityManagerFactory emf;
	
	private static DaoClient daoClient = new DaoClientJpaImpl();
	
	public static DaoClient getDaoClient() {
		return daoClient;
	}
	
private static DaoRestaurateur daoRestaurateur = new DaoRestaurateurJpaImpl();
	
	public static DaoRestaurateur getDaoRestaurateur() {
		return daoRestaurateur;
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
