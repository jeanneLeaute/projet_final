package ajc.formation.soprasteria.projetFinal.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.soprasteria.projetFinal.entities.Client;
import ajc.formation.soprasteria.projetFinal.entities.views.JsonViews;
import ajc.formation.soprasteria.projetFinal.services.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientRestController {
	
	@Autowired
	private ClientService clientSrv;
	
	@GetMapping("")
	@JsonView(JsonViews.Client.class)
	public List<Client> getAll() {
		return clientSrv.getAll();
	}
	
	@GetMapping("/{email}")
	@JsonView(JsonViews.Client.class)
	public Client getByEMail(@PathVariable String email) {
		Client client = null;
		client = clientSrv.getByEMail(email);
		return client;
	}
	
	@GetMapping("/{email}/commentaires")
	@JsonView(JsonViews.ClientWithCommentaire.class)
	public Client getByEMailWithCommentaires(@PathVariable String email) {
		Client client = null;
		client = clientSrv.getByEMailWithCommentaires(email);
		return client;
	}
	
	@GetMapping("/{email}/reservations")
	@JsonView(JsonViews.ClientWithReservation.class)
	public Client getByEMailWithReservations(@PathVariable String email) {
		Client client = null;
		client = clientSrv.getByEMailWithReservation(email);
		return client;
	}
	
	@PostMapping({"", "/inscription"})
	@JsonView(JsonViews.ClientWithReservation.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Client create(@Valid @RequestBody Client client, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		clientSrv.create(client);
		return client;
	}
	
	@PutMapping("/{email}")
	@JsonView(JsonViews.Client.class)
	public Client update(@RequestBody Client client, @PathVariable String email) {
		Client clientEnBase = clientSrv.getByEMail(email);
		if (client.getEMail() != null) {
			clientEnBase.setEMail(client.getEMail());
		}
		if (client.getNom() != null) {
			clientEnBase.setNom(client.getNom());
		}
		if (client.getPrenom() != null) {
			clientEnBase.setPrenom(client.getPrenom());
		}
		if (client.getMotDePasse() != null) {
			clientEnBase.setMotDePasse(client.getMotDePasse());
		}
		clientSrv.update(clientEnBase);
		return clientEnBase;
	}
	
	@DeleteMapping("/{email}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String email) {
		clientSrv.deleteByEMail(email);
	}

}
