package projetFinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFinal.entities.Client;
import projetFinal.entities.Restaurant;
import projetFinal.entities.Restaurateur;
import projetFinal.exceptions.ClientException;
import projetFinal.exceptions.RestaurateurException;
import projetFinal.repositories.RestaurateurRepository;

@Service
public class RestaurateurService {
	
	@Autowired
	RestaurateurRepository restaurateuRepo;
	
	public List<Restaurateur> getAll() {
		return restaurateuRepo.findAll();
	}
	
	public Restaurateur getByEMail(String eMail) {
		if (eMail == null) {
			throw new RestaurateurException("email obligatoire");
		}
		return restaurateuRepo.findById(eMail).orElseThrow(() -> {
			throw new RestaurateurException("email inconnu");
		});
	}
	
	public Restaurateur getByEMailWithRestaurants(String eMail) {
		if (eMail == null) {
			throw new RestaurateurException("email obligatoire");
		}
		return restaurateuRepo.findByEMailFetchRestaurants(eMail).orElseThrow(() -> {
			throw new RestaurateurException("email inconnu");
		});
	}
	
//	public Restaurateur getByRestaurant(Restaurant restaurant) {
//		if (restaurant == null) {
//			throw new RestaurateurException("restaurant obligatoire");
//		}
//		return restaurateuRepo.findByRestaurant(restaurant).orElseThrow(() -> {
//			throw new RestaurateurException("restaurant inconnu");
//		});
//	}
	
	public void deleteByEMail(String eMail) {
		restaurateuRepo.delete(getByEMail(eMail));
	}
	
	public void delete(Restaurateur restaurateur) {
		deleteByEMail(restaurateur.getEMail());
	}
	
	public void createOrUpdate(Restaurateur restaurateur) {
		if (restaurateur.getEMail() == null || restaurateur.getEMail().isBlank()) {
			throw new RestaurateurException("email obligatoire");
		}
		if (restaurateur.getNom() == null || restaurateur.getNom().isBlank()) {
			throw new RestaurateurException("nom obligatoire");
		}
		if (restaurateur.getPrenom() == null || restaurateur.getPrenom().isBlank()) {
			throw new RestaurateurException("prenom obligatoire");
		}
		if (restaurateur.getMotDePasse().length() < 5) {
			throw new RestaurateurException("mot de passe trop faible (minimum 5 caractères");
		}
		restaurateuRepo.save(restaurateur);
	}

}
