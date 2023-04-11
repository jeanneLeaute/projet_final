package projetFinal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import projetFinal.config.JpaConfig;
import projetFinal.entities.Client;
import projetFinal.entities.Adresse;
import projetFinal.entities.CommandeADomicile;
import projetFinal.entities.HeureReservation;
import projetFinal.entities.ItemMenu;
import projetFinal.entities.Reservation;
import projetFinal.entities.Restaurant;
import projetFinal.entities.SurPlace;
import projetFinal.services.ClientService;
import projetFinal.services.CommandeADomicileService;
import projetFinal.services.ReservationService;
import projetFinal.services.RestaurantService;
import projetFinal.services.SurPlaceService;
import projetFinal.exceptions.ReservationException;

@SpringJUnitConfig(JpaConfig.class)
@Transactional
@Rollback
public class ReservationTest {
	@Autowired
	ReservationService reservationService;
	@Autowired
	SurPlaceService surPlaceService;
	@Autowired
	CommandeADomicileService commandeADomicileService;
	@Autowired
	RestaurantService restaurantService;
	@Autowired
	ClientService clientService;

	@Test
	@Commit
	void initReservation() {
		Restaurant restau1 = new Restaurant("restau1", null);
		restaurantService.createOrUpdate(restau1);
		Client client = new Client("cl1", "cl1", "cl1", "cl1jhxv");
		clientService.createOrUpdate(client);
		surPlaceService.createOrUpdate(new SurPlace(client, restau1,LocalDate.now()," ",2,
				"bleu", null, HeureReservation.H11));
		surPlaceService.createOrUpdate(new SurPlace(client, restau1,LocalDate.now()," ",4,"rouge",null,HeureReservation.H19));
		Adresse adresse = new Adresse("4","h","kh","kj","ji");
		Set<ItemMenu> items= new HashSet<>();
		items.add(new ItemMenu("burger"));
		commandeADomicileService.createOrUpdate(new CommandeADomicile(client, restau1,LocalDate.now()," ",adresse,items));
	}

	@Test
	void injectionReservationServiceTest() {
		assertNotNull(reservationService);
	}

	@Test
	void insertReservationTest() {
		Restaurant restau1 = new Restaurant("restau1", null);
		restaurantService.createOrUpdate(restau1);
		Client client = new Client("cl1", "cl1", "cl1", "cl1xfh");
		clientService.createOrUpdate(client);
		SurPlace r = new SurPlace(client, restau1,LocalDate.now()," ",2,
				"bleu", null, HeureReservation.H11);
		surPlaceService.createOrUpdate(r);
		assertNotNull(reservationService.getById(r.getId_reservation()));
	}

	@Test
	void getByIdWithReservationException() {
		assertThrows(ReservationException.class, () -> reservationService.getById(9999L));
	}
}
