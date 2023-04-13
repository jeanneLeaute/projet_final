package ajc.formation.soprasteria.projetFinal.services;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import ajc.formation.soprasteria.projetFinal.entities.Compte;
import ajc.formation.soprasteria.projetFinal.entities.Role;
import ajc.formation.soprasteria.projetFinal.exception.CompteException;
import ajc.formation.soprasteria.projetFinal.repositories.CompteRepository;

public class CompteService {
	
	@Autowired
	private CompteRepository compteRepo;
	@Autowired
	private Validator validator;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public Compte createClient(Compte compte) {
		compte.setRole(Role.ROLE_CLIENT);
		return create(compte);
	}
	
	public Compte createRestaurateur(Compte compte) {
		compte.setRole(Role.ROLE_RESTAURATEUR);
		return create(compte);
	}

	public Compte createAdmin(Compte compte) {
		compte.setRole(Role.ROLE_ADMIN);
		return create(compte);
	}

	private Compte create(Compte compte) {
		if (!validator.validate(compte).isEmpty()) {
			throw new CompteException();
		}
		compte.setPassword(passwordEncoder.encode(compte.getPassword()));
		return compteRepo.save(compte);
	}

	public Compte findByLogin(String login) {
		return compteRepo.findByLogin(login).orElseThrow(() -> {
			throw new CompteException();
		});
	}

}
