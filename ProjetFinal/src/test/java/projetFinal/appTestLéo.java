package projetFinal;

import projetFinal.dao.Contexte;
import projetFinal.dao.DaoClient;
import projetFinal.dao.DaoCommentaire;
import projetFinal.dao.DaoItemMenu;
import projetFinal.dao.DaoReservation;
import projetFinal.dao.DaoRestaurant;
import projetFinal.dao.DaoRestaurateur;
import projetFinal.entities.Client;
import projetFinal.entities.Restaurateur;

public class appTestLéo {
 public static void main(String[] args) {
	 DaoClient daoClient = Contexte.getDaoClient();
	 DaoCommentaire daoCommentaire = Contexte.getDaoCommentaire();
	 DaoItemMenu daoItemMenu = Contexte.getDaoItemMenu();
	 DaoReservation daoReservation = Contexte.getDaoReservation();
	 DaoRestaurant daoRestaurant = Contexte.getDaoRestaurant();
	 DaoRestaurateur daoRestaurateur = Contexte.getDaoRestaurateur();
	 
	 Client clientLeo = new Client("Léo", "Paillat", "emailLéo", "motdepasse");
	 clientLeo = daoClient.save(clientLeo);
//	 daoClient.deleteByKey("email");
//	 daoClient.delete(client);
	 
	 Client clientJeanne = new Client("Jeanne", "jeanne", "emailJeanne", "motdepasse");
	 clientJeanne = daoClient.save(clientJeanne);
	 
	 Restaurateur restaurateur = new Restaurateur("Jeanne", "jeanne", "emailJeanne", "motdepasse");
	 restaurateur = daoRestaurateur.save(restaurateur);
//	 daoRestaurateur.deleteByKey("emailJeanne");
//	 daoRestaurateur.delete(restaurateur);
	 
	 Restaurateur restaurateurLeo = new Restaurateur("Léo", "Paillat", "emailLéo", "motdepasse");
	 restaurateurLeo = daoRestaurateur.save(restaurateurLeo);
	 
//	 System.out.println(daoClient.findAll());
//	 System.out.println(daoRestaurateur.findAll());
//	 System.out.println(daoClient.findByKey("emailJeanne"));
//	 System.out.println(daoRestaurateur.findByKey("emailLéo"));
	 
	 Contexte.destroy();
 	}
 
}
