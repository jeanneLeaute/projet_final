package projetFinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFinal.entities.Client;
import projetFinal.entities.Restaurant;
import projetFinal.entities.SurPlace;
import projetFinal.exceptions.ReservationException;
import projetFinal.repositories.SurPlaceRepository;

@Service
public class SurPlaceService {
	@Autowired
	private SurPlaceRepository surPlaceRepo;

	public List<SurPlace> getAll() {
		return surPlaceRepo.findAll();
	}

	public SurPlace getById(Long id) {
		if (id == null) {
			throw new ReservationException("id obligatoire");
		}
		return surPlaceRepo.findById(id).orElseThrow(() -> {
			throw new ReservationException("id inconnu");
		});
	}

	public void delete(SurPlace surPlace) {
		deleteById(surPlace.getId_reservation());
	}

	public void deleteById(Long id) {
		surPlaceRepo.delete(getById(id));
	}

	public void createOrUpdate(SurPlace surPlace) {
		if (surPlace.getClient() == null) {
			throw new ReservationException("client obligatoire");
		}
		if (surPlace.getRestaurant() == null) {
			throw new ReservationException("restaurant obligatoire");
		}
		if (surPlace.getDate() == null) {
			throw new ReservationException("date obligatoire");
		}
		if (surPlace.getHeureReservation()== null) {
			throw new ReservationException("heure obligatoire");
		}
		if (surPlace.getNbPersonne()==0) {
			throw new ReservationException("Nombre de client obligatoire");
		}
		surPlaceRepo.save(surPlace);
	}
	
	public List<SurPlace> getByClient(Client client) {
		if (client == null) {
			throw new ReservationException("client obligatoire");
		}
		
		if (surPlaceRepo.findByClient(client)==null) {
			throw new ReservationException("client inconnu");
		}
		return surPlaceRepo.findByClient(client);
	}
	
	public List<SurPlace> getByRestaurant(Restaurant restaurant) {
		if (restaurant == null) {
			throw new ReservationException("restaurant obligatoire");
		}
		
		if (surPlaceRepo.findByRestaurant(restaurant)==null) {
			throw new ReservationException("restaurant inconnu");
		}
		return surPlaceRepo.findByRestaurant(restaurant);
	}
}
