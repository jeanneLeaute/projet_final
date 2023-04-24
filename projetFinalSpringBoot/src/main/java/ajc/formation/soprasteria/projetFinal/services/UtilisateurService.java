package ajc.formation.soprasteria.projetFinal.services;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import ajc.formation.soprasteria.projetFinal.entities.Admin;
import ajc.formation.soprasteria.projetFinal.entities.Client;
import ajc.formation.soprasteria.projetFinal.entities.Restaurateur;
import ajc.formation.soprasteria.projetFinal.entities.Utilisateur;
import ajc.formation.soprasteria.projetFinal.repositories.AdminRepository;
import ajc.formation.soprasteria.projetFinal.repositories.ClientRepository;
import ajc.formation.soprasteria.projetFinal.repositories.RestaurateurRepository;

@Service
public class UtilisateurService {
	
	
	@Autowired
	AdminRepository adminRepo;
	@Autowired
	ClientRepository clientRepo;
	@Autowired
	RestaurateurRepository restaurateurRepo;

	public Utilisateur findByLogin(String login) {
		Admin admin = adminRepo.findByLogin(login).orElse(null);
		Restaurateur restaurateur = restaurateurRepo.findByLogin(login).orElse(null);
    	Client client = clientRepo.findByLogin(login).orElse(null);
    	if(admin!=null) {
    		return admin;
    	}else if(restaurateur!=null) {
    		return restaurateur;
    	}else {
    		return client;
    	}
	
	}
}
