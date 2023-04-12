package ajc.formation.soprasteria.projetFinal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.formation.soprasteria.projetFinal.entities.Client;
import ajc.formation.soprasteria.projetFinal.entities.CommandeADomicile;
import ajc.formation.soprasteria.projetFinal.entities.Restaurant;

public interface CommandeADomicileRepository extends JpaRepository<CommandeADomicile,Long>{
	List<CommandeADomicile> findByClient(Client client);

	List<CommandeADomicile> findByRestaurant(Restaurant restaurant);
}
