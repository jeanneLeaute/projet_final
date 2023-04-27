package ajc.formation.soprasteria.projetFinal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.formation.soprasteria.projetFinal.entities.Client;
import ajc.formation.soprasteria.projetFinal.entities.Restaurant;
import ajc.formation.soprasteria.projetFinal.entities.SurPlace;

public interface SurPlaceRepository extends JpaRepository<SurPlace,Long>{
	List<SurPlace> findByClient(Client client);

	List<SurPlace> findByRestaurant(Restaurant restaurant);
	
	List<SurPlace> findSurPlacesByItemMenuId(Long ItemMenuId);
}
