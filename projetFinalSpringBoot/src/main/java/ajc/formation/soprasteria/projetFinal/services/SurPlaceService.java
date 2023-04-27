package ajc.formation.soprasteria.projetFinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.formation.soprasteria.projetFinal.entities.Client;
import ajc.formation.soprasteria.projetFinal.entities.Restaurant;
import ajc.formation.soprasteria.projetFinal.entities.SurPlace;
import ajc.formation.soprasteria.projetFinal.exception.ReservationException;
import ajc.formation.soprasteria.projetFinal.repositories.ClientRepository;
import ajc.formation.soprasteria.projetFinal.repositories.RestaurantRepository;
import ajc.formation.soprasteria.projetFinal.repositories.SurPlaceRepository;

@Service
public class SurPlaceService {
	@Autowired
	private SurPlaceRepository surPlaceRepo;
	
	@Autowired
	private RestaurantRepository restaurantRepo;
	
	@Autowired
	private ClientRepository clientRepo;

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
	
	public List<SurPlace> getByRestaurantWithItemsMenu(Long id) {
		if (id == null || !restaurantRepo.existsById(id)) {
			throw new ReservationException("restaurant obligatoire");
		}
		
		return surPlaceRepo.findByRestaurantWithItemsMenu(id);
	}
	
	public List<SurPlace> getByClientWithItemsMenu(Long id) {
		if (id == null || !clientRepo.existsById(id)) {
			throw new ReservationException("client obligatoire");
		}
		
		return surPlaceRepo.findByClientWithItemsMenu(id);
	}
	
//	public List<SurPlace> findSurPlacesByItemMenuId(Long ItemMenuId){
//		if (ItemMenuId == null) {
//			throw new ReservationException("ItemMenu Id obligatoire");
//		}
//		
//		if (surPlaceRepo.findSurPlacesByItemMenuId(ItemMenuId)==null) {
//			throw new ReservationException("ItemMenu Id inconnu");
//		}
//		return surPlaceRepo.findSurPlacesByItemMenuId(ItemMenuId);
//	}
}
