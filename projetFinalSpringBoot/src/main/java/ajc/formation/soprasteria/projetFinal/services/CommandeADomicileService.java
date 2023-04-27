package ajc.formation.soprasteria.projetFinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.formation.soprasteria.projetFinal.entities.Client;
import ajc.formation.soprasteria.projetFinal.entities.CommandeADomicile;
import ajc.formation.soprasteria.projetFinal.entities.Restaurant;
import ajc.formation.soprasteria.projetFinal.entities.SurPlace;
import ajc.formation.soprasteria.projetFinal.exception.ReservationException;
import ajc.formation.soprasteria.projetFinal.repositories.ClientRepository;
import ajc.formation.soprasteria.projetFinal.repositories.CommandeADomicileRepository;
import ajc.formation.soprasteria.projetFinal.repositories.RestaurantRepository;

@Service
public class CommandeADomicileService {
	@Autowired
	private CommandeADomicileRepository commandeADomicileRepo;
	@Autowired
	private RestaurantRepository restaurantRepo;
	
	@Autowired
	private ClientRepository clientRepo;

	public List<CommandeADomicile> getAll() {
		return commandeADomicileRepo.findAll();
	}

	public CommandeADomicile getById(Long id) {
		if (id == null) {
			throw new ReservationException("id obligatoire");
		}
		return commandeADomicileRepo.findById(id).orElseThrow(() -> {
			throw new ReservationException("id inconnu");
		});
	}

	public void delete(CommandeADomicile commandeADomicile) {
		deleteById(commandeADomicile.getId_reservation());
	}

	public void deleteById(Long id) {
		commandeADomicileRepo.delete(getById(id));
	}

	public void createOrUpdate(CommandeADomicile commandeADomicile) {
		if (commandeADomicile.getClient() == null) {
			throw new ReservationException("client obligatoire");
		}
		if (commandeADomicile.getRestaurant() == null) {
			throw new ReservationException("restaurant obligatoire");
		}
		if (commandeADomicile.getDate() == null) {
			throw new ReservationException("date obligatoire");
		}
		if (commandeADomicile.getAdresse()== null) {
			throw new ReservationException("Adresse obligatoire");
		}
		if (commandeADomicile.getItemsMenu()==null) {
			throw new ReservationException("Items commandés obligatoire");
		}
		commandeADomicileRepo.save(commandeADomicile);
	}
	
	public List<CommandeADomicile> getByClient(Client client) {
		if (client == null) {
			throw new ReservationException("client obligatoire");
		}
		
		if (commandeADomicileRepo.findByClient(client)==null) {
			throw new ReservationException("client inconnu");
		}
		return commandeADomicileRepo.findByClient(client);
	}
	
	public List<CommandeADomicile> getByRestaurant(Restaurant restaurant) {
		if (restaurant == null) {
			throw new ReservationException("restaurant obligatoire");
		}
		
		if (commandeADomicileRepo.findByRestaurant(restaurant)==null) {
			throw new ReservationException("restaurant inconnu");
		}
		return commandeADomicileRepo.findByRestaurant(restaurant);
	}
	
	public List<CommandeADomicile> getByRestaurantWithItemsMenu(Long id) {
		if (id == null || !restaurantRepo.existsById(id)) {
			throw new ReservationException("restaurant obligatoire");
		}
		
		return commandeADomicileRepo.findByRestaurantWithItemsMenu(id);
	}
	
	public List<CommandeADomicile> getByClientWithItemsMenu(Long id) {
		if (id == null || !clientRepo.existsById(id)) {
			throw new ReservationException("client obligatoire");
		}
		
		return commandeADomicileRepo.findByClientWithItemsMenu(id);
	}
}
