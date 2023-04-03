package projetFinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFinal.exceptions.ReservationException;
import projetFinal.entities.Client;
import projetFinal.entities.Reservation;
import projetFinal.entities.Restaurant;
import projetFinal.repositories.ReservationRepository;

@Service
public class ReservationService {
	@Autowired
	private ReservationRepository reservationRepo;

	public List<Reservation> getAll() {
		return reservationRepo.findAll();
	}

	public Reservation getById(Long id) {
		if (id == null) {
			throw new ReservationException("id obligatoire");
		}
		return reservationRepo.findById(id).orElseThrow(() -> {
			throw new ReservationException("id inconnu");
		});
	}

	public void delete(Reservation reservation) {
		deleteById(reservation.getId_reservation());
	}

	public void deleteById(Long id) {
		reservationRepo.delete(getById(id));
	}

	// creation et mise a ensemble ou pas???
	public void createOrUpdate(Reservation reservation) {
		if (reservation.getClient() == null) {
			throw new ReservationException("client obligatoire");
		}
		if (reservation.getRestaurant() == null) {
			throw new ReservationException("restaurant obligatoire");
		}
		if (reservation.getDate() == null) {
			throw new ReservationException("date obligatoire");
		}
		reservationRepo.save(reservation);
	}
	
	public List<Reservation> getByClient(Client client) {
		if (client == null) {
			throw new ReservationException("client obligatoire");
		}
		
		if (reservationRepo.findByClient(client)==null) {
			throw new ReservationException("restaurant inconnu");
		}
		return reservationRepo.findByClient(client);
	}
	
	public List<Reservation> getByRestaurant(Restaurant restaurant) {
		if (restaurant == null) {
			throw new ReservationException("restaurant obligatoire");
		}
		
		if (reservationRepo.findByRestaurant(restaurant)==null) {
			throw new ReservationException("restaurant inconnu");
		}
		return reservationRepo.findByRestaurant(restaurant);
	}
}
