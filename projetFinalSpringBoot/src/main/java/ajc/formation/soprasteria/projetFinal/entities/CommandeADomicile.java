package ajc.formation.soprasteria.projetFinal.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.soprasteria.projetFinal.entities.views.JsonViews;

@DiscriminatorValue("a_domicile")
@Entity
public class CommandeADomicile extends Reservation{
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "numero", column = @Column(name = "commande_adresse_numero", length = 50)),
			@AttributeOverride(name = "rue", column = @Column(name = "commande_adresse_rue")),
			@AttributeOverride(name = "codePostal", column = @Column(name = "commande_adresse_codePostal", length = 20)),
			@AttributeOverride(name = "ville", column = @Column(name = "commande_adresse_ville")),
			@AttributeOverride(name = "complementAdresse", column = @Column(name = "commande_adresse_complementAdresse"))})
	@JsonView(JsonViews.Simple.class)
	private Adresse adresse;
	@ManyToMany(mappedBy = "commandesAdomicile")
	@JsonView(JsonViews.ADomicileWithItemsMenu.class)
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
