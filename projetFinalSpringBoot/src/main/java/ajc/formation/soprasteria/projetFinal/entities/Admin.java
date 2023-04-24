package ajc.formation.soprasteria.projetFinal.entities;

import java.util.Set;


import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
@AttributeOverride(name = "id", column = @Column(name="admin_id"))
@AttributeOverride(name = "nom", column = @Column(name="admin_nom"))
@AttributeOverride(name = "prenom", column = @Column(name="admin_prenom"))
@AttributeOverride(name = "login", column = @Column(name="admin_login"))
@AttributeOverride(name = "password", column = @Column(name="admin_password"))
@AttributeOverride(name = "role", column = @Column(name="admin_role"))

public class Admin extends Utilisateur {
	


	public Admin() {
		
	}

	public Admin(String nom, String prenom, String login, String password, Role role,
			Set<Restaurant> restaurants) {
		super(nom, prenom, login, password, role);
	}

	public Admin(Long id, String nom, String prenom, String login, String password, Role role,
			Set<Restaurant> restaurants) {
		super(id, nom, prenom, login, password, role);
	}

	public Admin(String nom, String prenom, String login, String password) {
		super(nom, prenom, login, password);
	}


}
