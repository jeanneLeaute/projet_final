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
import ajc.formation.soprasteria.projetFinal.entities.ClientRestaurantKey;
import ajc.formation.soprasteria.projetFinal.entities.Commentaire;
import ajc.formation.soprasteria.projetFinal.entities.Restaurant;
import ajc.formation.soprasteria.projetFinal.entities.views.JsonViews;
import ajc.formation.soprasteria.projetFinal.services.CommentaireService;

@RestController
@RequestMapping("/api/commentaire")
@CrossOrigin(origins = "*")
public class CommentaireRestController {

	@Autowired
	private CommentaireService commentaireService;

	@GetMapping("")
	@JsonView(JsonViews.Commentaire.class)
	public List<Commentaire> getAll() {
		return commentaireService.getAll();
	}
//D'après éclipse de la ligne 43-46 est la même méthode qu'à la ligne 72-77 --> mis en commentaire
//	@GetMapping("/{texte}")
//	@JsonView(JsonViews.Commentaire.class)
//	public List<Commentaire> getByTexteContaining(@PathVariable String texte) {
//		return commentaireService.getByTexte(texte);
//	}

	//!!!!
	@GetMapping("/{client}")
	@JsonView(JsonViews.Commentaire.class)
	public List<Commentaire> getByClient(@Valid @RequestBody Client client, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return commentaireService.getByClient(client);
	}

	@GetMapping("/{restaurant}")
	@JsonView(JsonViews.Commentaire.class)
	public List<Commentaire> getByRestaurant(@RequestBody Restaurant restaurant) {
		return commentaireService.getByRestaurant(restaurant);
	}

	@GetMapping("/{client}/{restaurant}")
	@JsonView(JsonViews.Commentaire.class)
	public List<Commentaire> getByRestaurantAndClient(@PathVariable Client client,
			@PathVariable Restaurant restaurant) {
		return commentaireService.getByRestaurantAndClient(restaurant, client);
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.Commentaire.class)
	public Commentaire getById(@PathVariable ClientRestaurantKey id) {
		Commentaire commentaire = null;
		commentaire = commentaireService.getById(id);
		return commentaire;
	}

	@PostMapping("")
	@JsonView(JsonViews.Commentaire.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Commentaire create(@Valid @RequestBody Commentaire commentaire, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		commentaireService.createOrUpdate(commentaire);
		return commentaire;
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Commentaire.class)
	public Commentaire update(@RequestBody Commentaire commentaire, @PathVariable ClientRestaurantKey id) {
		Commentaire commentaireEnBase = commentaireService.getById(id);
		if (commentaire.getTexte() != null) {
			commentaireEnBase.setTexte(commentaire.getTexte());
		}
		if (commentaire.getClient() != null) {
			commentaireEnBase.setClient(commentaire.getClient());
		}
		if (commentaire.getRestaurant() != null) {
			commentaireEnBase.setRestaurant(commentaire.getRestaurant());
		}

		return commentaireEnBase;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable ClientRestaurantKey id) {
		commentaireService.deleteById(id);
	}

}
