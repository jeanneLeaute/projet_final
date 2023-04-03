package projetFinal.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item_menu")
public class ItemMenu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item")
	private Long id_item;
	public Long getId_item() {
		return id_item;
	}

	public void setId_item(Long id_item) {
		this.id_item = id_item;
	}

	@Column(name = "urlImage")
	private String urlImage;
	@Column(name = "nom")
	private String nom;
	@Column(name = "description_menu")
	private String description;
	@Column(name = "categoriePlat")
	@Enumerated(EnumType.STRING)
	private CategoriePlat categoriePlat;
	@ManyToOne
	@JoinColumn(name = "restaurant_item_id", foreignKey = @ForeignKey(name="restaurant_item_id_fk"))
	private Restaurant restaurant;
	@ManyToMany
	@JoinColumn(name = "surPlace_item_id", foreignKey = @ForeignKey(name="surPlace_item_id_fk"))
	private Set<SurPlace> surPlaces;
	@ManyToMany
	@JoinColumn(name = "commande_item_id", foreignKey = @ForeignKey(name="commande_item_id_fk"))
	private Set<CommandeADomicile> commandesAdomicile;
	
	
	public ItemMenu() {
		super();
	}

	public ItemMenu(String urlImage, String nom, String description, CategoriePlat categoriePlat) {
		super();
		this.urlImage = urlImage;
		this.nom = nom;
		this.description = description;
		this.categoriePlat = categoriePlat;
	}
	
	

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CategoriePlat getCategoriePlat() {
		return categoriePlat;
	}

	public void setCategoriePlat(CategoriePlat categoriePlat) {
		this.categoriePlat = categoriePlat;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Set<SurPlace> getSurPlaces() {
		return surPlaces;
	}

	public void setSurPlaces(Set<SurPlace> surPlaces) {
		this.surPlaces = surPlaces;
	}

	public Set<CommandeADomicile> getCommandesAdomicile() {
		return commandesAdomicile;
	}

	public void setCommandesAdomicile(Set<CommandeADomicile> commandesAdomicile) {
		this.commandesAdomicile = commandesAdomicile;
	}
	
}
