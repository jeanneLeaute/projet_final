package projetFinal.entities;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Reservation {
	private Long id_reservation;
	private Client client;
	private Restaurant restaurant;
	private LocalDate date = LocalDate.now();
	private String specification;
	
	
	public Reservation(Client client, Restaurant restaurant, LocalDate date, String specification) {
		super();
		this.client = client;
		this.restaurant = restaurant;
		this.date = date;
		this.specification = specification;
	}


	public Reservation() {
		super();
	}


	public Reservation(Long id_reservation, Client client, Restaurant restaurant, LocalDate date,
			String specification) {
		super();
		this.id_reservation = id_reservation;
		this.client = client;
		this.restaurant = restaurant;
		this.date = date;
		this.specification = specification;
	}


	public Long getId_reservation() {
		return id_reservation;
	}


	public void setId_reservation(Long id_reservation) {
		this.id_reservation = id_reservation;
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


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public String getSpecification() {
		return specification;
	}


	public void setSpecification(String specification) {
		this.specification = specification;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id_reservation);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		return Objects.equals(id_reservation, other.id_reservation);
	}
	
}
