package ajc.formation.soprasteria.projetFinal.services;



import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ajc.formation.soprasteria.projetFinal.entities.Admin;
import ajc.formation.soprasteria.projetFinal.entities.Client;
import ajc.formation.soprasteria.projetFinal.entities.Restaurateur;
import ajc.formation.soprasteria.projetFinal.entities.Role;
import ajc.formation.soprasteria.projetFinal.exception.AdminException;
import ajc.formation.soprasteria.projetFinal.exception.ClientException;
import ajc.formation.soprasteria.projetFinal.repositories.AdminRepository;
import ajc.formation.soprasteria.projetFinal.repositories.ClientRepository;
import ajc.formation.soprasteria.projetFinal.repositories.RestaurateurRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepo;
	@Autowired
	private RestaurateurRepository restaurateurRepo;
	@Autowired
	private ClientRepository clientRepo;
	
	@Autowired
	private Validator validator;

	@Autowired
	private PasswordEncoder passwordEncoder;
	

	public Admin getById(Long id) {
		if (id == null) {
			throw new ClientException("id obligatoire");
		}
		return adminRepo.findById(id).orElseThrow(() -> {
			throw new ClientException("id inconnu");
		});
	}

	public Admin create(Admin admin) {
		if (!validator.validate(admin).isEmpty()) {
			throw new AdminException();
		}
		Client client = clientRepo.findByLogin(admin.getLogin()).orElse(null);;
		Restaurateur restaurateur =restaurateurRepo.findByLogin(admin.getLogin()).orElse(null); 
		if (client != null || restaurateur!=null) {
			throw new AdminException();
		}
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		admin.setRole(Role.ROLE_ADMIN);
		return adminRepo.save(admin);
	}
	
	public void deleteById(Long id) {
		adminRepo.delete(getById(id));
	}

	public void delete(Admin admin) {
		deleteById(admin.getId());
	}


}
