package ajc.formation.soprasteria.projetFinal.entities;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.soprasteria.projetFinal.entities.views.JsonViews;

@Entity
@Table(name = "restaurateur")
@AttributeOverride(name = "id", column = @Column(name="restaurateur_id"))
@AttributeOverride(name = "nom", column = @Column(name="restaurateur_nom"))
@AttributeOverride(name = "prenom", column = @Column(name="restaurateur_prenom"))
@AttributeOverride(name = "login", column = @Column(name="restaurateur_login"))
@AttributeOverride(name = "password", column = @Column(name="restaurateur_password"))
@AttributeOverride(name = "role", column = @Column(name="restaurateur_role"))

public class Restaurateur extends Utilisateur {
	
	@OneToMany(mappedBy = "restaurateur")
	@JsonView(JsonViews.RestaurateurWithRestaurant.class)
	private Set<Restaurant> restaurants;

	public Restaurateur() {
		
	}

	public Restaurateur(String nom, String prenom, String login, String password, Role role,
			Set<Restaurant> restaurants) {
		super(nom, prenom, login, password, role);
		this.restaurants = restaurants;
	}

	public Restaurateur(Long id, String nom, String prenom, String login, String password, Role role,
			Set<Restaurant> restaurants) {
		super(id, nom, prenom, login, password, role);
		this.restaurants = restaurants;
	}

	public Restaurateur(String nom, String prenom, String login, String password) {
		super(nom, prenom, login, password);
	}

	public Set<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(Set<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

}
