package ajc.formation.soprasteria.projetFinal.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.soprasteria.projetFinal.entities.views.JsonViews;

@Entity
@Table(name = "reservation")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "reservation_type",discriminatorType = DiscriminatorType.STRING,length = 100)
public abstract class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(JsonViews.Simple.class)
	private Long id_reservation;
	@ManyToOne
	@JoinColumn(name = "reservation_client_id", foreignKey = @ForeignKey(name = "reservation_client_id_fk"))
	@JsonView(JsonViews.Simple.class)
	private Client client;
	@ManyToOne
	@JoinColumn(name = "reservation_restaurant_id", foreignKey = @ForeignKey(name = "reservation_restaurant_id_fk"))
	@JsonView(JsonViews.Simple.class)
	private Restaurant restaurant;
	@Column(name="date_reservation")
	@JsonView(JsonViews.Simple.class)
	private LocalDate date = LocalDate.now();
	@Column(name="specification_reservation")
	@JsonView(JsonViews.Simple.class)
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
