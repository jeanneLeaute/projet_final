package projetFinal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projetFinal.entities.Client;
import projetFinal.entities.CommandeADomicile;
import projetFinal.entities.Restaurant;

public interface CommandeADomicileRepository extends JpaRepository<CommandeADomicile,Long>{
	List<CommandeADomicile> findByClient(Client client);

	List<CommandeADomicile> findByRestaurant(Restaurant restaurant);
}
