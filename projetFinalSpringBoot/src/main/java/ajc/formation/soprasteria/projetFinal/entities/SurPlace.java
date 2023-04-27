package ajc.formation.soprasteria.projetFinal.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.soprasteria.projetFinal.entities.views.JsonViews;

@DiscriminatorValue("sur_place")
@Entity
public class SurPlace extends Reservation{
	@JsonView(JsonViews.Simple.class)
	private int nbPersonne;
	@JsonView(JsonViews.Simple.class)
	private String choixTables;
	@ManyToMany(mappedBy = "surPlaces")
	@JsonView(JsonViews.SurPlaceWithItemsMenu.class)
	private Set<ItemMenu> itemsMenu;
	@Enumerated(EnumType.STRING)
	@JsonView(JsonViews.Simple.class)
	private HeureReservation heureReservation;
	
	public SurPlace() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SurPlace(Client client, Restaurant restaurant, LocalDate date, String specification, int nbPersonne,
			String choixTables, Set<ItemMenu> itemsMenu, HeureReservation heureReservation) {
		super(client, restaurant, date, specification);
		this.nbPersonne = nbPersonne;
		this.choixTables = choixTables;
		this.itemsMenu = itemsMenu;
		this.heureReservation = heureReservation;
	}

	public SurPlace(Long id_reservation,Client client, Restaurant restaurant, LocalDate date, String specification, int nbPersonne,
			String choixTables, Set<ItemMenu> itemsMenu, HeureReservation heureReservation) {
		super(id_reservation,client, restaurant, date, specification);
		this.nbPersonne = nbPersonne;
		this.choixTables = choixTables;
		this.itemsMenu = itemsMenu;
		this.heureReservation = heureReservation;
	}
	
	public SurPlace(Client client, Restaurant restaurant, LocalDate date, String specification, int nbPersonne,
			Set<ItemMenu> itemsMenu, HeureReservation heureReservation) {
		super(client, restaurant, date, specification);
		this.nbPersonne = nbPersonne;
		this.itemsMenu = itemsMenu;
		this.heureReservation = heureReservation;
	}

	public SurPlace(Long id_reservation,Client client, Restaurant restaurant, LocalDate date, String specification, int nbPersonne,
			Set<ItemMenu> itemsMenu, HeureReservation heureReservation) {
		super(id_reservation,client, restaurant, date, specification);
		this.nbPersonne = nbPersonne;
		this.itemsMenu = itemsMenu;
		this.heureReservation = heureReservation;
	}
	
	public SurPlace(Client client, Restaurant restaurant,String specification, int nbPersonne,
			Set<ItemMenu> itemsMenu, HeureReservation heureReservation) {
		super(client, restaurant,specification);
		this.nbPersonne = nbPersonne;
		this.itemsMenu = itemsMenu;
		this.heureReservation = heureReservation;
	}

	public SurPlace(Long id_reservation,Client client, Restaurant restaurant,String specification, int nbPersonne,
			Set<ItemMenu> itemsMenu, HeureReservation heureReservation) {
		super(id_reservation,client, restaurant,specification);
		this.nbPersonne = nbPersonne;
		this.itemsMenu = itemsMenu;
		this.heureReservation = heureReservation;
	}
	public SurPlace(Client client, Restaurant restaurant, LocalDate date, int nbPersonne,
			String choixTables, Set<ItemMenu> itemsMenu, HeureReservation heureReservation) {
		super(client, restaurant, date);
		this.nbPersonne = nbPersonne;
		this.choixTables = choixTables;
		this.itemsMenu = itemsMenu;
		this.heureReservation = heureReservation;
	}

	public SurPlace(Long id_reservation,Client client, Restaurant restaurant, LocalDate date, int nbPersonne,
			String choixTables, Set<ItemMenu> itemsMenu, HeureReservation heureReservation) {
		super(id_reservation,client, restaurant, date);
		this.nbPersonne = nbPersonne;
		this.choixTables = choixTables;
		this.itemsMenu = itemsMenu;
		this.heureReservation = heureReservation;
	}
	
	public SurPlace(Client client, Restaurant restaurant, LocalDate date, int nbPersonne,
			Set<ItemMenu> itemsMenu, HeureReservation heureReservation) {
		super(client, restaurant, date);
		this.nbPersonne = nbPersonne;
		this.itemsMenu = itemsMenu;
		this.heureReservation = heureReservation;
	}

	public SurPlace(Long id_reservation,Client client, Restaurant restaurant, LocalDate date, int nbPersonne,
			Set<ItemMenu> itemsMenu, HeureReservation heureReservation) {
		super(id_reservation,client, restaurant, date);
		this.nbPersonne = nbPersonne;
		this.itemsMenu = itemsMenu;
		this.heureReservation = heureReservation;
	}

	public int getNbPersonne() {
		return nbPersonne;
	}

	public void setNbPersonne(int nbPersonne) {
		this.nbPersonne = nbPersonne;
	}

	public String getChoixTables() {
		return choixTables;
	}

	public void setChoixTables(String choixTables) {
		this.choixTables = choixTables;
	}

	public Set<ItemMenu> getItemsMenu() {
		return itemsMenu;
	}

	public void setItemsMenu(Set<ItemMenu> itemsMenu) {
		this.itemsMenu = itemsMenu;
	}

	public HeureReservation getHeureReservation() {
		return heureReservation;
	}

	public void setHeureReservation(HeureReservation heureReservation) {
		this.heureReservation = heureReservation;
	}
}
