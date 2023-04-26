package ajc.formation.soprasteria.projetFinal.services;

import java.util.List;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.formation.soprasteria.projetFinal.entities.Client;
import ajc.formation.soprasteria.projetFinal.entities.ClientRestaurantKey;
import ajc.formation.soprasteria.projetFinal.entities.Commentaire;
import ajc.formation.soprasteria.projetFinal.entities.Restaurant;
import ajc.formation.soprasteria.projetFinal.entities.Restaurateur;
import ajc.formation.soprasteria.projetFinal.entities.Role;
import ajc.formation.soprasteria.projetFinal.exception.ClientException;
import ajc.formation.soprasteria.projetFinal.exception.CommentaireException;
import ajc.formation.soprasteria.projetFinal.repositories.CommentaireRepository;

@Service
public class CommentaireService {

	@Autowired
	private CommentaireRepository commentaireRepo;
	
	@Autowired
	private Validator validator;

	public List<Commentaire> getAll() {
		return commentaireRepo.findAll();
	}

	public Commentaire getById(Long id) {
		if (id == null) {
			throw new CommentaireException("id obligatoire");
		}
		return commentaireRepo.findById(id).orElseThrow(() -> {
			throw new CommentaireException("id inconnu");
		});
	}
	
	public Commentaire getByIdWithClient(Long id) {
		if (id == null) {
			throw new CommentaireException("id obligatoire");
		}
		return commentaireRepo.findByIdFetchClient(id).orElseThrow(() -> {
			throw new CommentaireException("id inconnu");
		});
	}
	
	public Commentaire getByIdWithRestaurant(Long id) {
		if (id == null) {
			throw new CommentaireException("id obligatoire");
		}
		return commentaireRepo.findByIdFetchRestaurant(id).orElseThrow(() -> {
			throw new CommentaireException("id inconnu");
		});
	}
	
	public List<Commentaire> getByTexte(String texte) {
		if (texte == null) {
			throw new CommentaireException("texte obligatoire");
		}
		return commentaireRepo.findByTexteContaining(texte);
	}

	public List<Commentaire> getByClient(Client client) {
		if (client == null) {
			throw new CommentaireException("client obligatoire");
		}
		return commentaireRepo.findByClient(client);
	}

	public List<Commentaire> getByRestaurant(Restaurant restaurant) {
		if (restaurant == null) {
			throw new CommentaireException("restaurant obligatoire");
		}
		return commentaireRepo.findByRestaurant(restaurant);
	}
	
	public List<Commentaire> getByRestaurantAndClient(Restaurant restaurant, Client client) {
		if (restaurant == null || client == null) {
			throw new CommentaireException("restaurant et client obligatoires");
		}
		return commentaireRepo.findByRestaurantAndClient(restaurant,client);
	}
	
	public void delete(Commentaire commentaire) {
		deleteById(commentaire.getId());
	}

	public void deleteById(Long id) {
		commentaireRepo.delete(getById(id));
	}

	public Commentaire create(Commentaire commentaire) {
		if (!validator.validate(commentaire).isEmpty()) {
			throw new CommentaireException();
		}
		return commentaireRepo.save(commentaire);
	}

	public Commentaire update(Commentaire commentaire) {
		if (!validator.validate(commentaire).isEmpty()) {
			throw new ClientException();
		}
		Commentaire commentairetEnBase = getById(commentaire.getId());
		commentairetEnBase.setTexte(commentaire.getTexte());
		commentairetEnBase.setClient(commentaire.getClient());
		commentairetEnBase.setRestaurant(commentaire.getRestaurant());
		return commentaireRepo.save(commentairetEnBase);
	}
}