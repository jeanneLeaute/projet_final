package projetFinalRest.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import projetFinal.entities.Client;
import projetFinal.entities.Reservation;
import projetFinal.entities.Restaurant;
import projetFinal.entities.SurPlace;
import projetFinal.entities.views.JsonViews;
import projetFinal.services.SurPlaceService;

@RestController
@RequestMapping("/api/SurPlace")
public class SurPlaceRestControler {
	@Autowired
	private SurPlaceService surPlaceService;

	@GetMapping("")
	@JsonView(JsonViews.SurPlace.class)
	public List<SurPlace> getAll() {
		return surPlaceService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.SurPlace.class)
	public SurPlace getById(@PathVariable("id") Long id) {
		return surPlaceService.getById(id);
	}


	@PostMapping("")
	@JsonView(JsonViews.SurPlace.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public SurPlace create(@Valid @RequestBody SurPlace surPlace, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		surPlaceService.createOrUpdate(surPlace);
		return surPlace;
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.SurPlace.class)
	public SurPlace update(@RequestBody SurPlace surPlace, @PathVariable Long id) {
		SurPlace reservationEnBase = surPlaceService.getById(id);
		if (surPlace.getClient() != null) {
			reservationEnBase.setClient(surPlace.getClient());
		}
		if (surPlace.getChoixTables() != null) {
			reservationEnBase.setChoixTables(surPlace.getChoixTables());
		}
		if (surPlace.getDate() != null) {
			reservationEnBase.setDate(surPlace.getDate());
		}
		if (surPlace.getHeureReservation() != null) {
			reservationEnBase.setHeureReservation(surPlace.getHeureReservation());
		}
		if (surPlace.getItemsMenu() != null) {
			reservationEnBase.setItemsMenu(surPlace.getItemsMenu());
		}
		if (surPlace.getNbPersonne() != 0) {
			reservationEnBase.setNbPersonne(surPlace.getNbPersonne());
		}
		if (surPlace.getRestaurant() != null) {
			reservationEnBase.setRestaurant(surPlace.getRestaurant());
		}
		if (surPlace.getSpecification() != null) {
			reservationEnBase.setSpecification(surPlace.getSpecification());
		}
		
		surPlaceService.createOrUpdate(reservationEnBase);
		return reservationEnBase;
	}
	

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		surPlaceService.deleteById(id);
	}
	
	@DeleteMapping("")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@RequestBody SurPlace surPlace) {
		surPlaceService.delete(surPlace);
	}
	
	@GetMapping("/getByClient")
	@JsonView(JsonViews.SurPlace.class)
	public List<SurPlace> getByClient(@RequestBody Client client) {
		return surPlaceService.getByClient(client);
	}
	
	@GetMapping("/getByRestaurant")
	@JsonView(JsonViews.SurPlace.class)
	public List<SurPlace> getByRestaurant(@RequestBody Restaurant restaurant) {
		return surPlaceService.getByRestaurant(restaurant);
	}
}
