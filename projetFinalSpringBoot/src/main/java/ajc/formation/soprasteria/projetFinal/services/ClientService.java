package ajc.formation.soprasteria.projetFinal.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ajc.formation.soprasteria.projetFinal.entities.Client;
import ajc.formation.soprasteria.projetFinal.entities.Restaurateur;
import ajc.formation.soprasteria.projetFinal.entities.Role;
import ajc.formation.soprasteria.projetFinal.exception.ClientException;
import ajc.formation.soprasteria.projetFinal.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepo;

	@Autowired
	private Validator validator;

	@Autowired
	private PasswordEncoder passwordEncoder;

//	@Autowired
//	private RestaurateurService restaurateurSrv;

	public List<Client> getAll() {
		return clientRepo.findAll();
	}

	public Client getById(Long id) {
		if (id == null) {
			throw new ClientException("id obligatoire");
		}
		return clientRepo.findById(id).orElseThrow(() -> {
			throw new ClientException("id inconnu");
		});
	}

	public Client getByLogin(String login) {
		if (login == null) {
			throw new ClientException("login obligatoire");
		}
		return clientRepo.findByLogin(login).orElseThrow(() -> {
			throw new ClientException("login inconnu");
		});
	}

	public Client getByIdWithReservation(Long id) {
		if (id == null) {
			throw new ClientException("id obligatoire");
		}
		return clientRepo.findByIdFetchReservations(id).orElseThrow(() -> {
			throw new ClientException("id inconnu");
		});
	}

	public Client getByIdWithCommentaires(Long id) {
		if (id == null) {
			throw new ClientException("id obligatoire");
		}
		return clientRepo.findByIdFetchCommentaires(id).orElseThrow(() -> {
			throw new ClientException("id inconnu");
		});
	}

	public Client getByIdWithReservationsWithCommentaires(Long id) {
		if (id == null) {
			throw new ClientException("id obligatoire");
		}
		return clientRepo.findByIdFetchReservationsFetchCommentaires(id).orElseThrow(() -> {
			throw new ClientException("id inconnu");
		});
	}

	public void deleteById(Long id) {
		clientRepo.delete(getById(id));
	}

	public void delete(Client client) {
		deleteById(client.getId());
	}

	public Client create(Client client) {
		if (!validator.validate(client).isEmpty()) {
			throw new ClientException();
		}
//		Restaurateur restaurateur = restaurateurSrv.getByLogin(client.getLogin());
//		if (restaurateur != null) {
//			throw new ClientException();
//		}
		client.setPassword(passwordEncoder.encode(client.getPassword()));
		client.setRole(Role.ROLE_CLIENT);
		return clientRepo.save(client);
	}
	

	public Client update(Client client) {
		if (!validator.validate(client).isEmpty()) {
			throw new ClientException();
		}
		Client clientEnBase = getById(client.getId());
		clientEnBase.setNom(client.getNom());
		clientEnBase.setPrenom(client.getPrenom());
		clientEnBase.setPassword(client.getPassword());
		return clientRepo.save(clientEnBase);
	}
}
