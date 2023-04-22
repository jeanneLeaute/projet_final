package ajc.formation.soprasteria.projetFinal.restcontroller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.soprasteria.projetFinal.entities.Utilisateur;
import ajc.formation.soprasteria.projetFinal.entities.views.JsonViews;

@RestController
@RequestMapping("api/auth")
@CrossOrigin(origins = "*")
public class AuthentificationRestController {
	
	@GetMapping("")
	@JsonView(JsonViews.Utilisateur.class)
	public Utilisateur authentification(@AuthenticationPrincipal Utilisateur utilisateur) {
		return utilisateur;
	}

}
