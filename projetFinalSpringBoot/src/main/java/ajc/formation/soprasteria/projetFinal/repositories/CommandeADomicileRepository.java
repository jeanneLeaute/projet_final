package ajc.formation.soprasteria.projetFinal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ajc.formation.soprasteria.projetFinal.entities.Client;
import ajc.formation.soprasteria.projetFinal.entities.CommandeADomicile;
import ajc.formation.soprasteria.projetFinal.entities.Restaurant;
import ajc.formation.soprasteria.projetFinal.entities.SurPlace;

public interface CommandeADomicileRepository extends JpaRepository<CommandeADomicile,Long>{
	List<CommandeADomicile> findByClient(Client client);

	List<CommandeADomicile> findByRestaurant(Restaurant restaurant);
	
	@Query("select distinct s from CommandeADomicile s left join fetch s.itemsMenu where s.restaurant.id = ?1")
	List<CommandeADomicile> findByRestaurantWithItemsMenu(Long idRestaurant);
}
