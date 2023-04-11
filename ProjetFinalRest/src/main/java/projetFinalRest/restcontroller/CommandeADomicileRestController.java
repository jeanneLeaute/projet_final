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

import projetFinal.entities.CommandeADomicile;
import projetFinal.entities.views.JsonViews;
import projetFinal.services.CommandeADomicileService;

@RestController
@RequestMapping("/api/CommandeADomicile")
public class CommandeADomicileRestController {
	
	@Autowired
	private CommandeADomicileService commandeADomicileService;

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
}
