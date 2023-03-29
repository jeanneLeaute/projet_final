package projetFinal.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item_menu")
public class ItemMenu {
	@Id
	@Column(name = "id_item")
	private String id_item;
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
	@ManyToOne
	@JoinColumn(name = "restaurateur_restaurant_id", foreignKey = @ForeignKey(name="restaurateur_restaurant_id_fk"))
	private Restaurateur restaurateur;
	
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
	
	
	
	

}
