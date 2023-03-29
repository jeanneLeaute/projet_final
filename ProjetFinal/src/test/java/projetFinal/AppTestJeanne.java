package projetFinal;

import java.time.LocalDate;
import java.util.List;

import projetFinal.dao.Contexte;
import projetFinal.dao.DaoClient;
import projetFinal.dao.DaoCommentaire;
import projetFinal.dao.DaoItemMenu;
import projetFinal.dao.DaoReservation;
import projetFinal.dao.DaoRestaurant;
import projetFinal.dao.DaoRestaurateur;
import projetFinal.entities.Client;
import projetFinal.entities.Commentaire;
import projetFinal.entities.Reservation;
import projetFinal.entities.Restaurant;
import projetFinal.entities.SurPlace;
import projetFinal.entities.Adresse;

public class AppTestJeanne {
	public static void main(String[] args) {
		test1();
		Contexte.destroy();
	}

	public static void test1() {
		DaoClient daoClient = Contexte.getDaoClient();
		DaoCommentaire daoCommentaire = Contexte.getDaoCommentaire();
		DaoItemMenu daoItemMenu = Contexte.getDaoItemMenu();
		DaoReservation daoReservation = Contexte.getDaoReservation();
		DaoRestaurant daoRestaurant = Contexte.getDaoRestaurant();
		DaoRestaurateur daoRestaurateur = Contexte.getDaoRestaurateur();
		Client client = new Client("Léo", "Paillat", "email", "motdepasse");
		client = daoClient.save(client);

		Adresse adresse = new Adresse(null, null, null, null, null);

		Restaurant restau1 = new Restaurant("email1", "nom1", adresse);
		restau1 = daoRestaurant.save(restau1);

		Reservation reservation1 = new SurPlace(client, restau1, LocalDate.now(), "none", 0, null, null, null);
		reservation1 = daoReservation.save(reservation1);

		List<Reservation> reser = daoReservation.findByRestaurant(restau1);
		System.out.println(reser);
	}
}
