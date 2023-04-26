package ajc.formation.soprasteria.projetFinal.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.formation.soprasteria.projetFinal.entities.Client;
import ajc.formation.soprasteria.projetFinal.entities.ClientRestaurantKey;
import ajc.formation.soprasteria.projetFinal.entities.Commentaire;
import ajc.formation.soprasteria.projetFinal.entities.Restaurant;

public interface CommentaireRepository extends JpaRepository<Commentaire, Long>{

	Optional<Commentaire> findById(Long id);

	List<Commentaire> findByTexteContaining(String Texte);

	List<Commentaire> findByClient(Client client);

	List<Commentaire> findByRestaurant(Restaurant restaurant);

	List<Commentaire> findByRestaurantAndClient(Restaurant restaurant, Client client);

}
