package ajc.formation.soprasteria.projetFinal.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import ajc.formation.soprasteria.projetFinal.entities.Client;
import ajc.formation.soprasteria.projetFinal.entities.CommandeADomicile;
import ajc.formation.soprasteria.projetFinal.entities.Restaurant;
import ajc.formation.soprasteria.projetFinal.entities.SurPlace;
import ajc.formation.soprasteria.projetFinal.entities.views.JsonViews;
import ajc.formation.soprasteria.projetFinal.services.CommandeADomicileService;
import ajc.formation.soprasteria.projetFinal.services.RestaurantService;

@RestController
@RequestMapping("/api/CommandeADomicile")
@CrossOrigin(origins = "*")
public class CommandeADomicileRestController {
	
	@Autowired
	private CommandeADomicileService commandeADomicileService;
	@Autowired
	private RestaurantService restaurantService;

	@GetMapping("")
	@JsonView(JsonViews.CommandeADomicile.class)
	public List<CommandeADomicile> getAll() {
		return commandeADomicileService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.CommandeADomicile.class)
	public CommandeADomicile getById(@PathVariable("id") Long id) {
		return commandeADomicileService.getById(id);
	}


	@PostMapping("")
	@JsonView(JsonViews.CommandeADomicile.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public CommandeADomicile create(@Valid @RequestBody CommandeADomicile CommandeADomicile, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		commandeADomicileService.createOrUpdate(CommandeADomicile);
		return CommandeADomicile;
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.CommandeADomicile.class)
	public CommandeADomicile update(@RequestBody CommandeADomicile commandeADomicile, @PathVariable Long id) {
		CommandeADomicile reservationEnBase = commandeADomicileService.getById(id);
		if (commandeADomicile.getClient() != null) {
			reservationEnBase.setClient(commandeADomicile.getClient());
		}
		if (commandeADomicile.getAdresse() != null) {
			reservationEnBase.setAdresse(commandeADomicile.getAdresse());
		}
		if (commandeADomicile.getDate() != null) {
			reservationEnBase.setDate(commandeADomicile.getDate());
		}
		if (commandeADomicile.getItemsMenu() != null) {
			reservationEnBase.setItemsMenu(commandeADomicile.getItemsMenu());
		}
		if (commandeADomicile.getRestaurant() != null) {
			reservationEnBase.setRestaurant(commandeADomicile.getRestaurant());
		}
		if (commandeADomicile.getSpecification() != null) {
			reservationEnBase.setSpecification(commandeADomicile.getSpecification());
		}
		
		commandeADomicileService.createOrUpdate(reservationEnBase);
		return reservationEnBase;
	}
	

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		commandeADomicileService.deleteById(id);
	}
	
	@DeleteMapping("")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@RequestBody CommandeADomicile CommandeADomicile) {
		commandeADomicileService.delete(CommandeADomicile);
	}
	
	@GetMapping("/getByClient")
	@JsonView(JsonViews.CommandeADomicile.class)
	public List<CommandeADomicile> getByClient(@RequestBody Client client) {
		return commandeADomicileService.getByClient(client);
	}
	
//	@GetMapping("/getByRestaurant")
//	@JsonView(JsonViews.CommandeADomicile.class)
//	public List<CommandeADomicile> getByRestaurant(@RequestBody Restaurant restaurant) {
//		return commandeADomicileService.getByRestaurant(restaurant);
//	}
	
	@GetMapping("/restau-reservation/{id}")
	@JsonView(JsonViews.CommandeADomicileWithItemsMenu.class)
	public List<CommandeADomicile> getByRestaurantWithItemsMenu(@PathVariable("id") Long id) {
//		Restaurant restaurant = restaurantService.getById(id);
		return commandeADomicileService.getByRestaurantWithItemsMenu(id);
	}
	
	@GetMapping("/client-reservation/{id}")
	@JsonView(JsonViews.CommandeADomicileWithItemsMenu.class)
	public List<CommandeADomicile> getByClientWithItemsMenu(@PathVariable("id") Long id) {
		return commandeADomicileService.getByClientWithItemsMenu(id);
	}
}
