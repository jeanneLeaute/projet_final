package projetFinal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projetFinal.entities.Client;
import projetFinal.entities.Reservation;
import projetFinal.entities.Restaurant;

public interface ReservationRepository extends JpaRepository<Reservation,Long>{

	List<Reservation> findByClient(Client client);

	List<Reservation> findByRestaurant(Restaurant restaurant);

	
}
