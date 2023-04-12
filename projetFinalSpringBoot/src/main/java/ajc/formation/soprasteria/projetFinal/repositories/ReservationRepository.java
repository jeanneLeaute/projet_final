package ajc.formation.soprasteria.projetFinal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.formation.soprasteria.projetFinal.entities.Client;
import ajc.formation.soprasteria.projetFinal.entities.Reservation;
import ajc.formation.soprasteria.projetFinal.entities.Restaurant;

public interface ReservationRepository extends JpaRepository<Reservation,Long>{

	List<Reservation> findByClient(Client client);

	List<Reservation> findByRestaurant(Restaurant restaurant);
	
}
