package projetFinal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import projetFinal.config.JpaConfig;
import projetFinal.entities.Client;
import projetFinal.entities.CommandeADomicile;
import projetFinal.entities.HeureReservation;
import projetFinal.entities.Reservation;
import projetFinal.entities.Restaurant;
import projetFinal.entities.SurPlace;
import projetFinal.services.ClientService;
import projetFinal.services.ReservationService;
import projetFinal.services.RestaurantService;

import projetFinal.exceptions.ReservationException;

@SpringJUnitConfig(JpaConfig.class)
@Transactional
@Rollback
public class AppTestJeanne {
	@Autowired
	ReservationService reservationService;
	@Autowired
	RestaurantService restaurantService;
	@Autowired
	ClientService clientService;

	@Disabled
	@Test
	@Commit
	void initReservation() {
		Restaurant restau1 = new Restaurant("restau1", null);
		restaurantService.createOrUpdate(restau1);
		Client client = new Client("cl1", "cl1", "cl1", "cl1");
		clientService.createOrUpdate(client);
		reservationService.createOrUpdate(new SurPlace(client, restau1,LocalDate.now()," ",2,
				"bleu", null, HeureReservation.H11));
		reservationService.createOrUpdate(new SurPlace(client, restau1,LocalDate.now()," ",4,"rouge",null,HeureReservation.H19));
		reservationService.createOrUpdate(new CommandeADomicile(client, restau1,LocalDate.now()," ",
				null, null));
	}

	@Test
	void injectionReservationServiceTest() {
		assertNotNull(reservationService);
	}

	@Test
	void insertReservationTest() {
		Restaurant restau1 = new Restaurant("restau1", null);
		restaurantService.createOrUpdate(restau1);
		Client client = new Client("cl1", "cl1", "cl1", "cl1");
		clientService.createOrUpdate(client);
		Reservation r = new SurPlace(client, restau1,LocalDate.now()," ",2,
				"bleu", null, HeureReservation.H11);
		reservationService.createOrUpdate(r);
		assertNotNull(reservationService.getById(r.getId_reservation()));
	}

	@Test
	void getByIdWithReservationException() {
		assertThrows(ReservationException.class, () -> reservationService.getById(9999L));
	}
}
