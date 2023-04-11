package projetFinalRest.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import projetFinal.entities.Reservation;
import projetFinal.entities.views.JsonViews;
import projetFinal.services.ReservationService;

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

}
