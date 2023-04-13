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
	
	public Client getByEMail(String eMail) {
		if (eMail == null) {
			throw new ClientException("email obligatoire");
		}
		return clientRepo.findById(eMail).orElseThrow(() -> {
			throw new ClientException("email inconnu");
		});
	}
	
	public Client getByEMailWithReservation(String eMail) {
		if (eMail == null) {
			throw new ClientException("email obligatoire");
		}
		return clientRepo.findByEMailFetchReservations(eMail).orElseThrow(() -> {
			throw new ClientException("email inconnu");
		});
	}
	
	public Client getByEMailWithCommentaires(String eMail) {
		if (eMail == null) {
			throw new ClientException("email obligatoire");
		}
		return clientRepo.findByEMailFetchCommentaires(eMail).orElseThrow(() -> {
			throw new ClientException("email inconnu");
		});
	}
	
	public Client getByEMailWithReservationsWithCommentaires(String eMail) {
		if (eMail == null) {
			throw new ClientException("email obligatoire");
		}
		return clientRepo.findByEMailFetchReservationsFetchCommentaires(eMail).orElseThrow(() -> {
			throw new ClientException("email inconnu");
		});
	}
	
	public void deleteByEMail(String eMail) {
		clientRepo.delete(getByEMail(eMail));
	}
	
	public void delete(Client client) {
		deleteByEMail(client.getEMail());
	}
	
	public Client create(Client client) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Client>> violations = validator.validate(client);
		if (violations.isEmpty()) {
			compteSrv.createClient(client.getCompte());
			return clientRepo.save(client);
		} else {
			throw new ClientException();
		}
	}
	
	public Client update(Client client) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Client>> violations = validator.validate(client);
		if (violations.isEmpty()) {
			Client clientEnBase = getByEMail(client.geteMail());
			clientEnBase.setNom(client.getNom());
			clientEnBase.setPrenom(client.getPrenom());
			return clientRepo.save(clientEnBase);
		} else {
			throw new ClientException();
		}
	}

}
