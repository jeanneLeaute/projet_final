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
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Client.class)
	public Client getById(@PathVariable Long id) {
		Client client = null;
		client = clientSrv.getById(id);
		return client;
	}
	
	@GetMapping("/{id}/commentaires")
	@JsonView(JsonViews.ClientWithCommentaire.class)
	public Client getByIdWithCommentaires(@PathVariable Long id) {
		Client client = null;
		client = clientSrv.getByIdWithCommentaires(id);
		return client;
	}
	
	@GetMapping("/{id}/reservations")
	@JsonView(JsonViews.ClientWithReservation.class)
	public Client getByIdWithReservations(@PathVariable Long id) {
		Client client = null;
		client = clientSrv.getByIdWithReservation(id);
		return client;
	}
	
	@GetMapping("/{login}/commentaires")
	@JsonView(JsonViews.ClientWithCommentaire.class)
	public Client getByLoginWithCommentaires(@PathVariable String login) {
		Client client = null;
		client = clientSrv.getByIdWithCommentaires(clientSrv.getByLogin(login).getId());
		return client;
	}
	
	@GetMapping("/{login}/reservations")
	@JsonView(JsonViews.ClientWithReservation.class)
	public Client getByLoginWithReservations(@PathVariable String login) {
		Client client = null;
		client = clientSrv.getByIdWithReservation(clientSrv.getByLogin(login).getId());
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
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Client.class)
	public Client update(@RequestBody Client client, @PathVariable Long id) {
		Client clientEnBase = clientSrv.getById(id);
		if (client.getNom() != null) {
			clientEnBase.setNom(client.getNom());
		}
		if (client.getPrenom() != null) {
			clientEnBase.setPrenom(client.getPrenom());
		}
		if (client.getPassword() != null) {
			clientEnBase.setPassword(client.getPassword());
		}
		clientSrv.update(clientEnBase);
		return clientEnBase;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clientSrv.deleteById(id);
	}

}
