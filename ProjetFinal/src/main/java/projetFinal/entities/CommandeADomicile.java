package projetFinal.entities;

import java.time.LocalDate;
import java.util.Set;

public class CommandeADomicile extends Reservation{
	private Adresse adresse;
	private Set<ItemMenu> itemsMenu;
	
	public CommandeADomicile() {
		super();
	}

	public CommandeADomicile(Client client, Restaurant restaurant, LocalDate date, String specification,
			Adresse adresse, Set<ItemMenu> itemsMenu) {
		super(client, restaurant, date, specification);
		this.adresse = adresse;
		this.itemsMenu = itemsMenu;
	}
	
	public CommandeADomicile(Long id_reservation, Client client, Restaurant restaurant, LocalDate date, String specification,
			Adresse adresse, Set<ItemMenu> itemsMenu) {
		super(id_reservation,client, restaurant, date, specification);
		this.adresse = adresse;
		this.itemsMenu = itemsMenu;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Set<ItemMenu> getItemsMenu() {
		return itemsMenu;
	}

	public void setItemsMenu(Set<ItemMenu> itemsMenu) {
		this.itemsMenu = itemsMenu;
	}
}
