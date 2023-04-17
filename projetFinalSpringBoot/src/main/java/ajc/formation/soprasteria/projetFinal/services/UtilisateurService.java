package ajc.formation.soprasteria.projetFinal.services;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import ajc.formation.soprasteria.projetFinal.entities.Client;
import ajc.formation.soprasteria.projetFinal.entities.Restaurateur;
import ajc.formation.soprasteria.projetFinal.entities.Utilisateur;
import ajc.formation.soprasteria.projetFinal.repositories.ClientRepository;
import ajc.formation.soprasteria.projetFinal.repositories.RestaurateurRepository;

@Service
public class UtilisateurService {
	
	
	@Autowired
	ClientRepository clientSrv;
	@Autowired
	RestaurateurRepository restaurateurSrv;

	public Utilisateur findByLogin(String login) {
		Restaurateur restaurateur = restaurateurSrv.findByLogin(login).orElse(null);
    	Client client = clientSrv.findByLogin(login).orElse(null);
    	if(restaurateur!=null) {
    		return restaurateur;
    	}
    	else {
    		return client;
    	}
	
	}
}
