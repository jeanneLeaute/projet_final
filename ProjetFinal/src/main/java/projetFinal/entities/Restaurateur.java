package projetFinal.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "restaurateur")
public class Restaurateur extends Utilisateur {
	
	private Set<Restaurant> restaurants;

	public Restaurateur() {
		
	}

	public Restaurateur(String nom, String prenom, String eMail, String motDePasse, Set<Restaurant> restaurants) {
		super(nom, prenom, eMail, motDePasse);
		this.restaurants = restaurants;
	}

	public Set<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(Set<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

}
