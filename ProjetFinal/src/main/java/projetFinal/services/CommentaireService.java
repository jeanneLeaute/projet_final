package projetFinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFinal.entities.Client;
import projetFinal.entities.ClientRestaurantKey;
import projetFinal.entities.Commentaire;
import projetFinal.entities.Restaurant;
import projetFinal.exceptions.CommentaireException;
import projetFinal.repositories.CommentaireRepository;

@Service
public class CommentaireService {

	@Autowired
	private CommentaireRepository commentaireRepo;

	public List<Commentaire> getAll() {
		return commentaireRepo.findAll();
	}

	public Commentaire getById(ClientRestaurantKey id) {
		if (id == null) {
			throw new CommentaireException("id obligatoire");
		}
		return commentaireRepo.findById(id).orElseThrow(() -> {
			throw new CommentaireException("id inconnu");
		});
	}
	public List<Commentaire> getByTexte(String texte) {
		return commentaireRepo.findByTexteContaining(texte);
	}

	public List<Commentaire> getByClient(Client client) {
		return commentaireRepo.findByClientContaining(client);
	}

	public List<Commentaire> getByRestaurant(Restaurant restaurant) {
		return commentaireRepo.findByRestaurantContaining(restaurant);
	}
	public List<Commentaire> getByRestaurantAndClient(Restaurant restaurant, Client client) {
		return commentaireRepo.findByRestaurantAndClient(restaurant,client);
	}
	public void delete(Commentaire commentaire) {
		deleteById(commentaire.getId());
	}

	public void deleteById(ClientRestaurantKey id) {
		commentaireRepo.delete(getById(id));
	}

	public void createOrUpdate(Commentaire commentaire) {
		if (commentaire.getTexte() == null || ((String) commentaire.getTexte()).isBlank()) {
			throw new CommentaireException("texte obligatoire");
		}

		commentaireRepo.save(commentaire);
	}

	
}