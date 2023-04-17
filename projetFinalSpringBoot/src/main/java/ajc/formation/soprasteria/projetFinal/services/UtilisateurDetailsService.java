package ajc.formation.soprasteria.projetFinal.services;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UtilisateurDetailsService implements UserDetailsService {

	@Autowired
	private UtilisateurService utilisateurateurSrv;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
		return utilisateurateurSrv.findByLogin(username);
	}
	
	

}
