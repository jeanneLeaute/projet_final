package projetFinal.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import projetFinal.entities.Client;
import projetFinal.entities.ClientRestaurantKey;
import projetFinal.entities.Commentaire;
import projetFinal.entities.Restaurant;

public interface CommentaireRepository extends JpaRepository<Commentaire, ClientRestaurantKey>{

	Optional<Commentaire> findById(ClientRestaurantKey id);

	List<Commentaire> findByTexteContaining(String Texte);

	List<Commentaire> findByClient(Client client);

	List<Commentaire> findByRestaurant(Restaurant restaurant);

	List<Commentaire> findByRestaurantAndClient(Restaurant restaurant, Client client);

}
