package ajc.formation.soprasteria.projetFinal.entities;

import java.io.Serializable;
import java.util.Objects;



public class ClientRestaurantKey implements Serializable {
	
	private Client client;
	
	private Restaurant restaurant;
	
	public ClientRestaurantKey () {

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
		ClientRestaurantKey other = (ClientRestaurantKey) obj;
		return Objects.equals(client, other.client) && Objects.equals(restaurant, other.restaurant);
	}
	
}


