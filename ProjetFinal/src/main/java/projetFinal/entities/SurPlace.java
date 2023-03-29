package projetFinal.entities;

import java.time.LocalDate;
import java.util.Set;

public class SurPlace extends Reservation{
	private int nbPersonne;
	private String choixTables;
	private Set<ItemMenu> itemsMenu=null;
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
