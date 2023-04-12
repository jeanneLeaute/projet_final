package ajc.formation.soprasteria.projetFinal.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.soprasteria.projetFinal.entities.Client;
import ajc.formation.soprasteria.projetFinal.entities.Reservation;
import ajc.formation.soprasteria.projetFinal.entities.views.JsonViews;
import ajc.formation.soprasteria.projetFinal.services.ReservationService;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationRestController {
	
	@Autowired
	private ReservationService reservationService;

	@GetMapping("")
	@JsonView(JsonViews.Reservation.class)
	public List<Reservation> getAll() {
		return reservationService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.Reservation.class)
	public Reservation getById(@PathVariable("id") Long id) {
		return reservationService.getById(id);
	}

	@GetMapping("/getByClient")
	@JsonView(JsonViews.Reservation.class)
	public List<Reservation> getByClient(@RequestBody Client client) {
		return reservationService.getByClient(client);
	}
	
	@GetMapping("/getByRestaurant")
	@JsonView(JsonViews.Reservation.class)
	public List<Reservation> getByRestaurant(@RequestBody Client client) {
		return reservationService.getByClient(client);
	}
}
