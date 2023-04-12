package ajc.formation.soprasteria.projetFinal.restcontroller;

import java.util.List;
import java.util.Optional;

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

import ajc.formation.soprasteria.projetFinal.entities.Categorie;
import ajc.formation.soprasteria.projetFinal.entities.Restaurant;
import ajc.formation.soprasteria.projetFinal.entities.views.JsonViews;
import ajc.formation.soprasteria.projetFinal.exception.RestaurantException;
import ajc.formation.soprasteria.projetFinal.services.RestaurantService;


@RestController
@RequestMapping("api/restaurant")
public class RestaurantRestController {
	
	@Autowired
	private RestaurantService restaurantSrv;
	
	@GetMapping("")
	@JsonView(JsonViews.Simple.class)
	public List<Restaurant> getAll() {
		return restaurantSrv.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Simple.class)
	public Restaurant getById(@PathVariable Long id) {
		Restaurant restaurant=null;
		try {
			restaurant=restaurantSrv.getById(id);
		} catch (RestaurantException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return restaurant;
	}
	
	@GetMapping("/{id}/restaurateur")
	@JsonView(JsonViews.RestaurantWithRestaurateur.class)
	public Restaurant getByIdWithRestaurateur(@PathVariable Long id) {
		Restaurant restaurant=null;
		try {
			restaurant=restaurantSrv.getById(id);
		} catch (RestaurantException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return restaurant;
	}
	
	@GetMapping("/{id}/itemMenu")
	@JsonView(JsonViews.RestaurantWithItemsMenu.class)
	public Optional<Restaurant> getByIdWithItemMenu(@PathVariable Long id) {
		Optional<Restaurant> restaurant=null;
		try {
			restaurant=restaurantSrv.findByIdAvecMenu(id);
		} catch (RestaurantException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return restaurant;
	}
	
	@GetMapping("/{id}/commentaires")
	@JsonView(JsonViews.RestaurantWithCommentaire.class)
	public Optional<Restaurant> getByIdWithCommentaires(@PathVariable Long id) {
		Optional<Restaurant> restaurant=null;
		try {
			restaurant=restaurantSrv.findByIdAvecCommentaires(id);
		} catch (RestaurantException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return restaurant;
	}
	
	@GetMapping("/ville")
	@JsonView(JsonViews.Simple.class)
	public List<Restaurant> getByVille(@PathVariable String ville) {
		List<Restaurant> restaurants=null;
		try {
			restaurants=restaurantSrv.findByVille(ville);
		} catch (RestaurantException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return restaurants;
	}
	
	@GetMapping("/categorie")
	@JsonView(JsonViews.Simple.class)
	public List<Restaurant> getByCategories(@PathVariable Categorie categorie) {
		List<Restaurant> restaurants=null;
		try {
			restaurants=restaurantSrv.findByCategorie(categorie);
		} catch (RestaurantException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return restaurants;
	}
	
	@GetMapping("/categorie/ville")
	@JsonView(JsonViews.Simple.class)
	public List<Restaurant> getByCategoriesAndVille(@PathVariable Categorie categorie,@PathVariable String ville) {
		List<Restaurant> restaurants=null;
		try {
			restaurants=restaurantSrv.findByCategorieAndVille(categorie, ville);
		} catch (RestaurantException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return restaurants;
	}
	
	@PostMapping("")
	@JsonView(JsonViews.Simple.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Restaurant create(@Valid @RequestBody Restaurant restaurant, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		restaurantSrv.createOrUpdate(restaurant);
		return restaurant;
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Simple.class)
	public Restaurant update(@RequestBody Restaurant restaurant, @PathVariable Long id) {
		Restaurant restaurantEnBase = restaurantSrv.getById(id);
		if (restaurant.getAdresse() != null) {
			restaurantEnBase.setAdresse(restaurant.getAdresse());
		}
		if (restaurant.getCategories() != null) {
			restaurantEnBase.setCategories(restaurant.getCategories());
		}
		if (restaurant.getDescription() != null) {
			restaurantEnBase.setDescription(restaurant.getDescription());
		}
		if (restaurant.getHoraireOuverture() != null) {
			restaurantEnBase.setHoraireOuverture(restaurant.getHoraireOuverture());
		}
		if (restaurant.getNom() != null) {
			restaurantEnBase.setNom(restaurant.getNom());
		}
		if (restaurant.getUrlImage() != null) {
			restaurantEnBase.setUrlImage(restaurant.getUrlImage());
		}
		if (restaurant.getRestaurateur() != null) {
			restaurantEnBase.setRestaurateur(restaurant.getRestaurateur());
		}
		restaurantSrv.createOrUpdate(restaurantEnBase);
		return restaurantEnBase;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Restaurant restaurant=null;
		try {
			restaurant=restaurantSrv.getById(id);
		} catch (RestaurantException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		restaurantSrv.deleteByKey(id);
	}

}
