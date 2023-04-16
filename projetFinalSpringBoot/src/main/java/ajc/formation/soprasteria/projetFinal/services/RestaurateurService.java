package ajc.formation.soprasteria.projetFinal.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.formation.soprasteria.projetFinal.entities.Restaurateur;
import ajc.formation.soprasteria.projetFinal.exception.ClientException;
import ajc.formation.soprasteria.projetFinal.exception.RestaurateurException;
import ajc.formation.soprasteria.projetFinal.repositories.RestaurateurRepository;

@Service
public class RestaurateurService {
	
	@Autowired
	private RestaurateurRepository restaurateuRepo;
	
	@Autowired
	private CompteService compteSrv;
	
	public List<Restaurateur> getAll() {
		return restaurateuRepo.findAll();
	}
	
	public Restaurateur getById(Long id) {
		if (id == null) {
			throw new RestaurateurException("id obligatoire");
		}
		return restaurateuRepo.findById(id).orElseThrow(() -> {
			throw new RestaurateurException("id inconnu");
		});
	}
	
	public Restaurateur getByIdWithRestaurants(Long id) {
		if (id == null) {
			throw new RestaurateurException("id obligatoire");
		}
		return restaurateuRepo.findByIdFetchRestaurants(id).orElseThrow(() -> {
			throw new RestaurateurException("id inconnu");
		});
	}
	
	public Restaurateur getByLogin(String login) {
		if (login == null) {
			throw new RestaurateurException("login obligatoire");
		}
		return restaurateuRepo.findByLogin(login).orElseThrow(() -> {
			throw new RestaurateurException("login inconnu");
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
	
	public void deleteById(Long id) {
		restaurateuRepo.delete(getById(id));
	}
	
	public void delete(Restaurateur restaurateur) {
		deleteById(restaurateur.getId());
	}
	
	public Restaurateur create(Restaurateur restaurateur) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Restaurateur>> violations = validator.validate(restaurateur);
		if (violations.isEmpty()) {
			if (restaurateuRepo.findByLogin(restaurateur.getLogin()) != null) {
				throw new ClientException("login déjà utilisé");
			} else {
				return restaurateuRepo.save(restaurateur);
			}
		} else {
			throw new RestaurateurException();
		}
	}
	
	public Restaurateur update(Restaurateur restaurateur) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Restaurateur>> violations = validator.validate(restaurateur);
		if (violations.isEmpty()) {
			Restaurateur restaurateurEnBase = getById(restaurateur.getId());
			restaurateurEnBase.setNom(restaurateur.getNom());
			restaurateurEnBase.setPrenom(restaurateur.getPrenom());
			restaurateurEnBase.setPassword(restaurateur.getPassword());
			return restaurateuRepo.save(restaurateurEnBase);
		} else {
			throw new RestaurateurException();
		}
	}

}
