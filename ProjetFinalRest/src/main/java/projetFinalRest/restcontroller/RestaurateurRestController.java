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

import projetFinal.entities.Restaurateur;
import projetFinal.entities.views.JsonViews;
import projetFinal.services.RestaurateurService;

@RestController
@RequestMapping("/api/restaurateur")
public class RestaurateurRestController {
	
	@Autowired
	private RestaurateurService restaurateurSrv;
	
	@GetMapping("")
	@JsonView(JsonViews.Restaurateur.class)
	public List<Restaurateur> getAll() {
		return restaurateurSrv.getAll();
	}
	
	@GetMapping("/{email}")
	@JsonView(JsonViews.Restaurateur.class)
	public Restaurateur getByEMail(@PathVariable String email) {
		Restaurateur restaurateur = null;
		restaurateur = restaurateurSrv.getByEMail(email);
		return restaurateur;
	}
	
	@GetMapping("/{email}/restaurants")
	@JsonView(JsonViews.RestaurateurWithRestaurant.class)
	public Restaurateur getByEMailWithRestaurants(@PathVariable String email) {
		Restaurateur restaurateur = null;
		restaurateur = restaurateurSrv.getByEMailWithRestaurants(email);
		return restaurateur;
	}
	
	@PostMapping("")
	@JsonView(JsonViews.RestaurateurWithRestaurant.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Restaurateur create(@Valid @RequestBody Restaurateur restaurateur, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		restaurateurSrv.createOrUpdate(restaurateur);
		return restaurateur;
	}
	
	@PutMapping("/{email}")
	@JsonView(JsonViews.Client.class)
	public Restaurateur update(@RequestBody Restaurateur restaurateur, @PathVariable String email) {
		Restaurateur restaurateurEnBase = restaurateurSrv.getByEMail(email);
		if (restaurateur.getEMail() != null) {
			restaurateurEnBase.setEMail(restaurateur.getEMail());
		}
		if (restaurateur.getNom() != null) {
			restaurateurEnBase.setNom(restaurateur.getNom());
		}
		if (restaurateur.getPrenom() != null) {
			restaurateurEnBase.setPrenom(restaurateur.getPrenom());
		}
		if (restaurateur.getMotDePasse() != null) {
			restaurateurEnBase.setMotDePasse(restaurateur.getMotDePasse());
		}
		restaurateurSrv.createOrUpdate(restaurateurEnBase);
		return restaurateurEnBase;
	}
	
	@DeleteMapping("/{email}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String email) {
		restaurateurSrv.deleteByEMail(email);
	}

}
