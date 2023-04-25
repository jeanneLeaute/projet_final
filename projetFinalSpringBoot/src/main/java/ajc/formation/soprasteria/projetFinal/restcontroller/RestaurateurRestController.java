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

import ajc.formation.soprasteria.projetFinal.entities.Restaurateur;
import ajc.formation.soprasteria.projetFinal.entities.views.JsonViews;
import ajc.formation.soprasteria.projetFinal.services.RestaurantService;
import ajc.formation.soprasteria.projetFinal.services.RestaurateurService;

@RestController
@RequestMapping("/api/restaurateur")
@CrossOrigin(origins = "*")
public class RestaurateurRestController {
	
	@Autowired
	private RestaurateurService restaurateurSrv;
	
	@Autowired
	private RestaurantService restaurantSrv;
	
	@GetMapping("")
	@JsonView(JsonViews.Restaurateur.class)
	public List<Restaurateur> getAll() {
		return restaurateurSrv.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Restaurateur.class)
	public Restaurateur getById(@PathVariable Long id) {
		Restaurateur restaurateur = null;
		restaurateur = restaurateurSrv.getById(id);
		return restaurateur;
	}
	
	@GetMapping("/{id}/restaurants")
	@JsonView(JsonViews.RestaurateurWithRestaurant.class)
	public Restaurateur getByIdWithRestaurants(@PathVariable Long id) {
		Restaurateur restaurateur = null;
		restaurateur = restaurateurSrv.getByIdWithRestaurants(id);
		return restaurateur;
	}
	
	@GetMapping("/login/{login}")
	@JsonView(JsonViews.Restaurateur.class)
	public Restaurateur getByLogin(@PathVariable String login) {
		Restaurateur restaurateur = null;
		restaurateur = restaurateurSrv.getByLogin(login);
		return restaurateur;
	}
	
	@GetMapping("/login/{login}/restaurants")
	@JsonView(JsonViews.RestaurateurWithRestaurant.class)
	public Restaurateur getByLoginWithRestaurants(@PathVariable String login) {
		Restaurateur restaurateur = null;
		restaurateur = restaurateurSrv.getByIdWithRestaurants(restaurateurSrv.getByLogin(login).getId());
		return restaurateur;
	}
	
	@GetMapping("/restaurant/{idRestaurant}")
	@JsonView(JsonViews.Restaurateur.class)
	public Restaurateur getByIdRestaurant(@PathVariable Long  idRestaurant) {
		Restaurateur restaurateur = null;
		restaurateur = restaurantSrv.getById(idRestaurant).getRestaurateur();
		return restaurateur;
	}
	
//	@GetMapping("/{nomRestaurant}")
//	@JsonView(JsonViews.Restaurateur.class)
//	public Restaurateur getByNomRestaurant(@PathVariable String  nomRestaurant) {
//		Restaurateur restaurateur = null;
//		restaurateur = restaurantSrv.getByNom(nomRestaurant).getRestaurateur();
//		return restaurateur;
//	}
	
	@PostMapping({"", "/inscription"})
	@JsonView(JsonViews.RestaurateurWithRestaurant.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Restaurateur create(@Valid @RequestBody Restaurateur restaurateur, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		restaurateurSrv.create(restaurateur);
		return restaurateur;
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Client.class)
	public Restaurateur update(@RequestBody Restaurateur restaurateur, @PathVariable Long id) {
		Restaurateur restaurateurEnBase = restaurateurSrv.getById(id);
		if (restaurateur.getNom() != null) {
			restaurateurEnBase.setNom(restaurateur.getNom());
		}
		if (restaurateur.getPrenom() != null) {
			restaurateurEnBase.setPrenom(restaurateur.getPrenom());
		}
		if (restaurateur.getLogin() != null) {
			restaurateurEnBase.setLogin(restaurateur.getLogin());
		}
		if (restaurateur.getPassword() != null) {
			restaurateurEnBase.setPassword(restaurateur.getPassword());
		}
		restaurateurSrv.update(restaurateurEnBase);
		return restaurateurEnBase;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		restaurateurSrv.deleteById(id);
	}

	@GetMapping("/login/check/{login}")
	public boolean loginExist(@PathVariable String login) {
		return restaurateurSrv.loginExist(login);
	} 
}
