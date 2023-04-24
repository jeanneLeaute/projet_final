package ajc.formation.soprasteria.projetFinal.services;

import java.util.List;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ajc.formation.soprasteria.projetFinal.entities.Client;
import ajc.formation.soprasteria.projetFinal.entities.Restaurateur;
import ajc.formation.soprasteria.projetFinal.entities.Role;
import ajc.formation.soprasteria.projetFinal.exception.RestaurateurException;
import ajc.formation.soprasteria.projetFinal.repositories.ClientRepository;
import ajc.formation.soprasteria.projetFinal.repositories.RestaurateurRepository;

@Service
public class RestaurateurService {

	@Autowired
	private RestaurateurRepository restaurateurRepo;
	@Autowired
	private Validator validator;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ClientRepository clientRepo;

	public List<Restaurateur> getAll() {
		return restaurateurRepo.findAll();
	}

	public Restaurateur getById(Long id) {
		if (id == null) {
			throw new RestaurateurException("id obligatoire");
		}
		return restaurateurRepo.findById(id).orElseThrow(() -> {
			throw new RestaurateurException("id inconnu");
		});
	}

	public Restaurateur getByIdWithRestaurants(Long id) {
		if (id == null) {
			throw new RestaurateurException("id obligatoire");
		}
		return restaurateurRepo.findByIdFetchRestaurants(id).orElseThrow(() -> {
			throw new RestaurateurException("id inconnu");
		});
	}

	public Restaurateur getByLogin(String login) {
		if (login == null) {
			throw new RestaurateurException("login obligatoire");
		}
		return restaurateurRepo.findByLogin(login).orElseThrow(() -> {
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
		restaurateurRepo.delete(getById(id));
	}

	public void delete(Restaurateur restaurateur) {
		deleteById(restaurateur.getId());
	}

	public Restaurateur create(Restaurateur restaurateur) {
		if (!validator.validate(restaurateur).isEmpty()) {
			throw new RestaurateurException();
		}
		Client client = clientRepo.findByLogin(restaurateur.getLogin()).orElse(null);
		if (client != null) {
			throw new RestaurateurException();
		}
		restaurateur.setPassword(passwordEncoder.encode(restaurateur.getPassword()));
		restaurateur.setRole(Role.ROLE_RESTAURATEUR);
		return restaurateurRepo.save(restaurateur);
	}

	public Restaurateur update(Restaurateur restaurateur) {
		if (!validator.validate(restaurateur).isEmpty()) {
			throw new RestaurateurException();
		}
		Restaurateur restaurateurEnBase = getById(restaurateur.getId());
		restaurateurEnBase.setNom(restaurateur.getNom());
		restaurateurEnBase.setPrenom(restaurateur.getPrenom());
		restaurateurEnBase.setPassword(restaurateur.getPassword());
		return restaurateurRepo.save(restaurateurEnBase);
	}

}