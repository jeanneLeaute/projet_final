package projetFinal.entities;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import projetFinal.exceptions.ClientException;

@Entity
@Table(name = "restaurateur")
@AttributeOverride(name = "eMail", column = @Column(name="restaurateur_email"))
@AttributeOverride(name = "nom", column = @Column(name="restaurateur_nom"))
@AttributeOverride(name = "prenom", column = @Column(name="restaurateur_prenom"))
@AttributeOverride(name = "motDePasse", column = @Column(name="restaurateur_mot_de_passe"))
public class Restaurateur extends Utilisateur {
	
	@OneToMany(mappedBy = "restaurateur")
	private Set<Restaurant> restaurants;

	public Restaurateur() {
		
	}

	public Restaurateur(String nom, String prenom, String eMail, String motDePasse, Set<Restaurant> restaurants) {
		super(nom, prenom, eMail, motDePasse);
		this.restaurants = restaurants;
	}

	public Restaurateur(String nom, String prenom, String eMail, String motDePasse) {
		super(nom, prenom, eMail, motDePasse);
	}

	public Set<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(Set<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

}
