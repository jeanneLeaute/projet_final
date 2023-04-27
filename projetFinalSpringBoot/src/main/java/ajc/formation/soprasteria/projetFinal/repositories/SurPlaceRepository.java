package ajc.formation.soprasteria.projetFinal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ajc.formation.soprasteria.projetFinal.entities.Client;
import ajc.formation.soprasteria.projetFinal.entities.Restaurant;
import ajc.formation.soprasteria.projetFinal.entities.SurPlace;

public interface SurPlaceRepository extends JpaRepository<SurPlace,Long>{
	List<SurPlace> findByClient(Client client);

	List<SurPlace> findByRestaurant(Restaurant restaurant);
	
	@Query("select distinct s from SurPlace s left join fetch s.itemsMenu where s.restaurant.id = ?1")
	List<SurPlace> findByRestaurantWithItemsMenu(Long idRestaurant);
	
//	List<SurPlace> findSurPlacesByItemMenuId(Long ItemMenuId);
}
