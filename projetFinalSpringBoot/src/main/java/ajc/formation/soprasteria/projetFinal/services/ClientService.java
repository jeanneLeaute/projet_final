package ajc.formation.soprasteria.projetFinal.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.formation.soprasteria.projetFinal.entities.Client;
import ajc.formation.soprasteria.projetFinal.exception.ClientException;
import ajc.formation.soprasteria.projetFinal.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepo;

	@Autowired
	CompteService compteSrv;

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
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Client>> violations = validator.validate(client);
		if (violations.isEmpty()) {
			if (clientRepo.findByLogin(client.getLogin()) != null) {
				throw new ClientException("login déjà utilisé");
			} else {
				return clientRepo.save(client);
			}

		} else {
			throw new ClientException();
		}
	}

	public Client update(Client client) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Client>> violations = validator.validate(client);
		if (violations.isEmpty()) {
			Client clientEnBase = getById(client.getId());
			clientEnBase.setNom(client.getNom());
			clientEnBase.setPrenom(client.getPrenom());
			clientEnBase.setPassword(client.getPassword());
			return clientRepo.save(clientEnBase);
		} else {
			throw new ClientException();
		}
	}

}
