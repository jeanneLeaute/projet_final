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
	
	public Restaurateur create(Restaurateur restaurateur) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Restaurateur>> violations = validator.validate(restaurateur);
		if (violations.isEmpty()) {
			compteSrv.createRestaurateur(restaurateur.getCompte());
			return restaurateuRepo.save(restaurateur);
		} else {
			throw new RestaurateurException();
		}
	}
	
	public Restaurateur update(Restaurateur restaurateur) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Restaurateur>> violations = validator.validate(restaurateur);
		if (violations.isEmpty()) {
			Restaurateur restaurateurEnBase = getByEMail(restaurateur.geteMail());
			restaurateurEnBase.setNom(restaurateur.getNom());
			restaurateurEnBase.setPrenom(restaurateur.getPrenom());
			return restaurateuRepo.save(restaurateurEnBase);
		} else {
			throw new RestaurateurException();
		}
	}

}
