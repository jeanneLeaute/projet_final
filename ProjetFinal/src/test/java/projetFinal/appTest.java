package projetFinal;

import projetFinal.dao.Contexte;
import projetFinal.dao.DaoClient;
import projetFinal.dao.DaoCommentaire;
import projetFinal.dao.DaoItemMenu;
import projetFinal.dao.DaoReservation;
import projetFinal.dao.DaoRestaurant;
import projetFinal.dao.DaoRestaurateur;
import projetFinal.entities.Client;

public class appTest {
 public static void main(String[] args) {
	 DaoClient daoClient = Contexte.getDaoClient();
	 DaoCommentaire daoCommentaire = Contexte.getDaoCommentaire();
	 DaoItemMenu daoItemMenu = Contexte.getDaoItemMenu();
	 DaoReservation daoReservation = Contexte.getDaoReservation();
	 DaoRestaurant daoRestaurant = Contexte.getDaoRestaurant();
	 DaoRestaurateur daoRestaurateur = Contexte.getDaoRestaurateur();
	 
	 Client client = new Client("Léo", "Paillat", "email", "motdepasse");
	 client = daoClient.save(client);
	 
	 Contexte.destroy();
	
 }
}
