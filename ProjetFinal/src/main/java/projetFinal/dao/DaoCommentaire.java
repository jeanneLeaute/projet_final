package projetFinal.dao;

import java.util.List;

import projetFinal.entities.Client;
import projetFinal.entities.Commentaire;
import projetFinal.entities.Restaurant;

public interface DaoCommentaire extends DaoGenerique<Commentaire, String> {

		public List<Commentaire> findByClient(Client client);
		public List<Commentaire> findByRestaurant(Restaurant restaurant);
}
