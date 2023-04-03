package projetFinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFinal.entities.Client;
import projetFinal.exceptions.ClientException;
import projetFinal.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository clientRepo;
	
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
	
	public void createOrUpdate(Client client) {
		if (client.getEMail() == null || client.getEMail().isBlank()) {
			throw new ClientException("email obligatoire");
		}
		if (client.getNom() == null || client.getNom().isBlank()) {
			throw new ClientException("nom obligatoire");
		}
		if (client.getPrenom() == null || client.getPrenom().isBlank()) {
			throw new ClientException("prenom obligatoire");
		}
		if (client.getMotDePasse().length() < 5) {
			throw new ClientException("mot de passe trop faible (minimum 5 caractères");
		}
		clientRepo.save(client);
	}

}
