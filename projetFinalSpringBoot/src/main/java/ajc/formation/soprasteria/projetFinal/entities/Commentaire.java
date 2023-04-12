package ajc.formation.soprasteria.projetFinal.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.soprasteria.projetFinal.entities.views.JsonViews;

@Entity
@Table(name = "commentaire")
@IdClass(ClientRestaurantKey.class)
public class Commentaire {
	
	@JsonView(JsonViews.Simple.class)
	@Column(name = "texte")
	private String texte;
	
	
	@Id
	@ManyToOne
	@JoinColumn(name="commentaire_client",foreignKey = @ForeignKey(name="commentaire_client_fk"))
	@JsonView(JsonViews.Simple.class)
	private Client client;
	
	@Id
	@ManyToOne
	@JoinColumn(name="commentaire_restaurant",foreignKey = @ForeignKey(name="commentaire_restaurant_fk"))
	@JsonView(JsonViews.Simple.class)
	private Restaurant restaurant;

	public Commentaire() {

	}

	public Commentaire(String texte, Client client, Restaurant restaurant) {
		super();
		this.texte = texte;
		this.client = client;
		this.restaurant = restaurant;
	}


	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	@Override
	public int hashCode() {
		return Objects.hash(client, restaurant);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commentaire other = (Commentaire) obj;
		return Objects.equals(client, other.client) && Objects.equals(restaurant, other.restaurant);
	}

	public ClientRestaurantKey getId() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
