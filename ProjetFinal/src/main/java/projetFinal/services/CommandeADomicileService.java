package projetFinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFinal.entities.Client;
import projetFinal.entities.Restaurant;
import projetFinal.entities.CommandeADomicile;
import projetFinal.exceptions.ReservationException;
import projetFinal.repositories.CommandeADomicileRepository;

@Service
public class CommandeADomicileService {
	@Autowired
	private CommandeADomicileRepository commandeADomicileRepo;

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
}
