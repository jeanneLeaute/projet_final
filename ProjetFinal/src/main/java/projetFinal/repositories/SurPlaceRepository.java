package projetFinal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projetFinal.entities.Client;
import projetFinal.entities.Restaurant;
import projetFinal.entities.SurPlace;

public interface SurPlaceRepository extends JpaRepository<SurPlace,Long>{
	List<SurPlace> findByClient(Client client);

	List<SurPlace> findByRestaurant(Restaurant restaurant);
}
