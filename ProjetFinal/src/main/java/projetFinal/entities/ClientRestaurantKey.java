package projetFinal.entities;

import java.io.Serializable;

import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ClientRestaurantKey implements Serializable {
	@ManyToOne
	@JoinColumn(name="",foreignKey = @ForeignKey(name=""))
	private Client client;
	@ManyToOne
	@JoinColumn(name="",foreignKey = @ForeignKey(name=""))
	private Restaurant restaurant;
	
	public ClientRestaurantKey clientRestaurantKey() {

	}

	public ClientRestaurantKey(Client client, Restaurant restaurant) {
		super();
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
	
}


